
from tkinter import *
from tkinter import ttk
import pymysql as MySQLdb
from pylab import *
from matplotlib.backends.backend_tkagg import (FigureCanvasTkAgg, NavigationToolbar2Tk)

class Dbconnect(object):    
    def __init__(self):
        self.dbconection = MySQLdb.connect(host='localhost',port=3306, user='root',passwd='',db='dbcomptoire')
        self.dbcursor = self.dbconection.cursor()
    def commit_db(self):
        self.dbconection.commit()
    def close_db(self):
        self.dbcursor.close()
        self.dbconection.close()

class Windows(Frame):

    try:
        cnx=Dbconnect()
        cnx.dbcursor.execute("SELECT nom FROM employés")
        noms = cnx.dbcursor.fetchall()
        cnx.dbcursor.execute("SELECT employes.Nom, Year(commandes.DateCommande) as AnCom, sum( PrixUnitaire*Quantité *(1-Remise) ) as mt FROM (dbcomptoire.commandes commandes INNER JOIN dbcomptoire.détailscommandes detailscommandes ON (commandes.NCommande = detailscommandes.NCommande)) INNER JOIN dbcomptoire.employés employes ON (employes.NEmployé = commandes.NEmployé) group by Nom,Year(commandes.DateCommande)")
        total_mt_annee = cnx.dbcursor.fetchall()
        cnx.dbcursor.execute("SELECT employes.Nom, year(commandes.DateCommande),sum( commandes.DateEnvoi - commandes.ALivrerAvant ) as totalRetar FROM dbcomptoire.employés employes INNER JOIN dbcomptoire.commandes commandes ON (employes.NEmployé = commandes.NEmployé) where (commandes.DateEnvoi-commandes.ALivrerAvant)> 0 group by employes.Nom, year(commandes.DateCommande)")
        retard_annee = cnx.dbcursor.fetchall()
    except MySQLError as ex:
        print(ex)
    

    def __init__(self,windws,**kwargs):
        Frame.__init__(self,windws, width=500, height=500, ** kwargs)
        self.pack(fill=BOTH)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label1=Label(self, text = "Merci de choisir un Employé",font=40)
        self.label1.grid(row=0,column=0)
        liste_nom=[]
        for value in Windows.noms:
            liste_nom.append(value[0])
        self.combo = ttk.Combobox( self , values = liste_nom)
        self.combo.grid(row=0,column=3)
        self.combo.bind("<<ComboboxSelected>>",self.display_statistic)
        #+++++++++++++++++++++++++++++++++++++++++++++
    
    def display_statistic(self,event):
        res1=Windows.total_mt_annee
        nom=self.combo.get()
        list1=[]
        for row in res1:
            if(row[0]==nom):
                list1.append(row)
        res1=np.array(list1)
        annee=res1.transpose()[1]
        somme=res1.transpose()[2]
        fig = plt.figure(figsize=(4, 5))
        plt.bar(x=annee, height=somme)
        ylabel("MT")
        xlabel("année")
        canvas = FigureCanvasTkAgg(fig,master=self)
        canvas.draw()
        canvas.get_tk_widget().grid(row=4, column=2, ipadx=40, ipady=20)
        #++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        res2=Windows.retard_annee
        list2=[]
        for row in res2:
            if(row[0]==nom):
                list2.append(row)
        res2=np.array(list2)
        annee=res2.transpose()[1]
        retard=res2.transpose()[2]
        fig = plt.figure(figsize=(4, 5))
        plt.bar(x=annee, height=retard)
        ylabel("Retard")
        xlabel("année")
        canvas = FigureCanvasTkAgg(fig,master=self)
        canvas.draw()
        canvas.get_tk_widget().grid(row=4, column=4, ipadx=40, ipady=20)
 
        
        
     


windws=Tk()
win=Windows(windws)
win.mainloop()








