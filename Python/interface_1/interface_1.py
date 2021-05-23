
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
        cnx.dbcursor.execute("SELECT * FROM employés")
        results = cnx.dbcursor.fetchall()
        index=-1  #variable statique pour passer d'un employe à autre
    except MySQLError as ex:
        print(ex)

    def __init__(self,windws,**kwargs):
        Frame.__init__(self,windws, width=500, height=500, ** kwargs)
        self.pack(fill=BOTH)
        #++++++++++++++++++++++++++++++++++++++++++++++
        tabControl = ttk.Notebook(self) 
        tab1 = ttk.Frame(tabControl) 
        tab2 = ttk.Frame(tabControl) 
        tabControl.add(tab1, text ='info société') 
        tabControl.add(tab2, text ='info personnelles') 
        tabControl.grid(row=0,column=0)
        #++++++++++++++++++++++++++++++++++++++++++++++++
        self.label1=Label(tab1, text = "N° employe",font=40)
        self.label1.grid(row=0,column=0)
        self.input1=Entry(tab1,bd=4,width=40)
        self.input1.grid(row=0,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label2=Label(tab1, text = "Nom",font=40)
        self.label2.grid(row=1,column=0)
        self.input2=Entry(tab1,bd=4,width=40)
        self.input2.grid(row=1,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label3=Label(tab1, text = "Prénom",font=40)
        self.label3.grid(row=2,column=0)
        self.input3=Entry(tab1,bd=4,width=40)
        self.input3.grid(row=2,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label4=Label(tab1, text = "Fonction",font=40)
        self.label4.grid(row=3,column=0)
        self.input4=Entry(tab1,bd=4,width=40)
        self.input4.grid(row=3,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label5=Label(tab2, text = "Adresse",font=40)
        self.label5.grid(row=0,column=0)
        self.input5=Entry(tab2,bd=4,width=40)
        self.input5.grid(row=0,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.label6=Label(tab2, text = "N° de téléphone",font=40)
        self.label6.grid(row=1,column=0)
        self.input6=Entry(tab2,bd=4,width=40)
        self.input6.grid(row=1,column=1)
        #+++++++++++++++++++++++++++++++++++++++++++++
        frame1= Frame(self)
        frame1.grid(row=4,column=0)
        #+++++++++++++++++++++++++++++++++++++++++++++
        self.btn1=Button(frame1, text = "<",bg="blue",font=50,command=self.go_back)
        self.btn1.grid(row=1,column=0)
        self.btn2=Button(frame1, text = ">",font=50,bg="blue",command=self.go_up)
        self.btn2.grid(row=1,column=3)
        #++++++++++++++++++++++++++++++++++++++++++++++
        self.btn4=Button(frame1, text = "Quitter",font=50,bg="red",width=20,command=self.destroy)
        self.btn4.grid(row=1,column=6)
        self.go_up()

    def go_up(self):
            if((Windows.index+1)<len(Windows.results)):
                i=0
                Windows.index+=1
                inputs=[self.input1,self.input2,self.input3,self.input4,self.input5,self.input6]
                for value in Windows.results[Windows.index]:
                    inputs[i].delete(0,'end')
                    inputs[i].insert(0,value)
                    i+=1
           

    def go_back(self):
            if(Windows.index>0):
                Windows.index-=1
                i=0
                inputs=[self.input1,self.input2,self.input3,self.input4,self.input5,self.input6]
                for value in Windows.results[Windows.index]:
                    inputs[i].delete(0,'end')
                    inputs[i].insert(0,value)
                    i+=1
            
windws=Tk()
win=Windows(windws)
win.mainloop()








