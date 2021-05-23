
"""Q1 Définir la classe « Connexion » permettant d’obtenir une connexion à la base de données
« GestionPersonnes »."""

import pymysql
class Dbconnect(object):
    def __init__(self):
        self.dbconection=pymysql.connect(host="localhost"
                                         ,user="root",
                                         db="gestionpersonnes",
                                         passwd="root")
        
        self.dbcursor = self.dbconection.cursor()
    def commit_db(self):
        self.dbconection.commit()
    def close_db(self):
        self.dbcursor.close() ; self.dbconection.close()


""" Définir la classe permettant d’assuer les fonctionalités de cette interface."""
from tkinter import *
from tkinter import ttk
class Interface(Frame):
    def __init__(self, fenetre, **kwargs):
        Frame.__init__(self, fenetre,** kwargs)
        self.db = Dbconnect()
        self.pack(fill=BOTH)
        self.var = IntVar()
        # Création des widgets
        self.NomPrenom = Label ( self , text = "Saisissez votre nom complet : " )
        self.dateN = Label ( self , text = "Saisissez votre date de naissance : " )
        self.sexe = Label ( self , text = "sexe : " )
        self.R1 = Radiobutton(self, text="masculin",variable=self.var, value=1)
        self.R2 = Radiobutton(self, text="feminin",variable=self.var, value=2)
        self.email = Label ( self , text = "Saisissez votre email : " )
        self.profil = Label ( self , text = "Profil : " )
        self.profilCombo = ttk.Combobox(self, 
                            values=[
                                    "big data", 
                                    "aero",
                                    "math",
                                    "phys"])
        
        self.champNomPrenom  = Entry ( self ,bg="grey")
        self.champdate = Entry(self,bg="grey")
        self.champemail = Entry(self,bg="grey")
        
        self.NomPrenom.grid (row=0, column=0)
        self.champNomPrenom.grid (row=0, column=1)
        self.champdate.grid (row=1, column=1)
        self.sexe.grid (row=1, column=0)
        self.R1.grid (row=1, column=1)
        self.R2.grid (row=1, column=2)
        self.dateN.grid (row=2, column=0)
        self.champdate.grid (row=2, column=1)
        self.email.grid (row=3, column=0)
        self.champemail.grid (row=3, column=1)
        self.profil.grid(row=4, column=0)
        self.profilCombo.grid(row=4, column=1)
        self.profilCombo.current(0)  

        
        self.btnQuit= Button(self, text=" Annuler ",bg="red",command=self.destroy)
        self.btnQuit.grid(row=6, column=1)
        self.btnAdd=Button(self,text=" Ajouter",command= self.addPerson , bg="green")
        self.btnAdd.grid(row=6, column=0 )
    def addPerson(self):
        req ="INSERT INTO personne values (?,?,?,?)",
        (self.champNomPrenom.get(),self.var.get(),self.champdate.get(),self.champemail.get())
        req2 = "INSERT INTO profil values (?)",
        (self.profilCombo.get())
        self.db.dbcursor.execute(req)
        self.db.dbcursor.execute(req2)
        self.db.commit_db()
        self.db.close_db()
fenetre = Tk()
fenetre.geometry("400x150")
fenetre.title("ajout de nouveau personne")
interface = Interface(fenetre)
interface.mainloop()
interface.destroy()




























