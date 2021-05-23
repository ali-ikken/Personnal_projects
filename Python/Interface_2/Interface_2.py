
from tkinter import *
from tkinter import ttk
import pymysql as MySQLdb

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
        cnx.dbcursor.execute("SELECT c.Ncommande,DateCommande,AlivrerAvant,DateEnvoi,cl.codeClient,société FROM commandes c,clients cl where c.CodeClient=cl.codeClient")
        infosCommands = cnx.dbcursor.fetchall()
        cnx.dbcursor.execute("SELECT c.Ncommande,p.RéfProduit,nomProduit,quantité FROM commandes c,détailscommandes d ,produits p  where c.Ncommande=d.Ncommande and d.RéfProduit=p.RéfProduit")
        detailCommand = cnx.dbcursor.fetchall()
    except MySQLError as ex:
        print(ex)


    def __init__(self,windws,**kwargs):
        Frame.__init__(self,windws, width=500, height=500, ** kwargs)
        self.pack(fill=BOTH)
        #++++++++++++++++++++++++++++++++++++++++++++++
        infos_command = LabelFrame(self, text="Infos commande")
        infos_command.grid(row=0,column=0)
        detail_command = LabelFrame(self, text="Infos commande")
        detail_command.grid(row=1,column=0)

        #++++++++++++++++++++++++++++++++++++++++++++++++
        self.label1=Label(infos_command, text = "Merci de choisir un N° commande",font=40)
        self.label1.grid(row=0,column=0)
        liste_id=[]
        for value in Windows.infosCommands:
            liste_id.append(value[0])
        self.combo = ttk.Combobox( infos_command , values = liste_id)
        self.combo.grid(row=0,column=1)
        self.combo.bind("<<ComboboxSelected>>", self.show_data)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label2=Label(infos_command, text = "Date commande",font=40)
        self.label2.grid(row=1,column=0)
        self.input1=Entry(infos_command,bd=4,width=40)
        self.input1.grid(row=1,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label3=Label(infos_command, text = "A livrer commande",font=40)
        self.label3.grid(row=2,column=0)
        self.input2=Entry(infos_command,bd=4,width=40)
        self.input2.grid(row=2,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label4=Label(infos_command, text = "Date d'envoi",font=40)
        self.label4.grid(row=3,column=0)
        self.input3=Entry(infos_command,bd=4,width=40)
        self.input3.grid(row=3,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label5=Label(infos_command, text = "Code client",font=40)
        self.label5.grid(row=4,column=0)
        self.input4=Entry(infos_command,bd=4,width=40)
        self.input4.grid(row=4,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label6=Label(infos_command, text = "société",font=40)
        self.label6.grid(row=5,column=0)
        self.input5=Entry(infos_command,bd=4,width=40)
        self.input5.grid(row=5,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.tree = ttk.Treeview(detail_command,columns=(1,2,3),height=5,show="headings")
        self.tree.pack()
        self.tree.column(1, width=100)
        self.tree.column(2, width=100)
        self.tree.column(3, width=100) 
        self.tree.heading(1,text="Réf produit")
        self.tree.heading(2, text="Nom du produit")
        self.tree.heading(3, text="Qt com")
        sbar = ttk.Scrollbar(detail_command,orient='vertical',command=self.tree.yview)
        sbar.pack(side=RIGHT, fill=Y)
        self.tree.pack(side=LEFT, expand=YES, fill=BOTH)
        self.tree.configure(yscroll=sbar.set)

    def show_data(self,event):
                self.clearTree()
                id_cmd=int(self.combo.get())
                for row in Windows.infosCommands:
                    if(row[0]==id_cmd):
                        inputs=[self.input1,self.input2,self.input3,self.input4,self.input5]
                        for i in range(0,5):
                            inputs[i].delete(0,'end')
                            inputs[i].insert(0,row[i+1])
                        for row in Windows.detailCommand:
                             if(row[0]==id_cmd):
                                self.tree.insert('','end', values=(row[1], row[2], row[3]))
               
    def clearTree(self):
        for i in self.tree.get_children():
                        self.tree.delete(i)

windws=Tk()
win=Windows(windws)
win.mainloop()








