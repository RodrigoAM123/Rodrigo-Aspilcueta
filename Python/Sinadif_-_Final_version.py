from time import *
from os import *
from random import *

class Registro:
    dnisregistrados=[]
    def __init__(self):
        self.__nombres=input("Ingrese sus nombres: ")
        self.__ap=input("Ingrese su apellido paterno: ")
        self.__am=input("Ingrese su apellido materno: ")
        self.__dni=input("Ingrese su dni: ")
        self.__edad=int(input("Ingrese su edad: "))
        self.__contraseña=input("Ingrese su contraseña: ")
        self.validacion_dni()
        self.validacion_edad()
        self.validacion_contra()
        Registro.dnisregistrados.append(self.__dni)
        
    def getnombres(self):
        return self.__nombres
    def setnombres(self):
        self.__nombres=input("Ingrese sus nombres: ")
    def getap(self):
        return self.__ap
    def setap(self):
        self.__ap=input("Ingrese su apellido paterno: ")
    def getam(self):
        return self.__am
    def setam(self):
        self.__am=input("Ingrese su apellido materno: ")
    def getdni(self):
        return self.__dni
    def setdni(self):
        self.__dni=input("Ingrese su dni: ")
        self.validacion_dni()
    def getedad(self):
        return self.__edad
    def setedad(self):
        self.__edad=int(input("Ingrese su edad: "))
        self.validacion_edad()
    def getcontraseña(self):
        return self.__contraseña
    def setcontraseña(self):
        self.__contraseña=input("Ingrese su contraseña: ")
        self.validacion_contra()

    def validacion_edad(self):
        while self.__edad<18 or self.__edad>100:
            print("ERROR: Edad invalida")
            self.__edad=int(input("Ingrese correctamente su edad: "))

    def validacion_contra(self):
        validacion=input("Vuelva a ingresar su contraseña para confirmar: ")
        while validacion!=self.__contraseña:
            print("ERROR: las contraseñas ingresadas no coinciden")
            validacion=input("Vuelva a ingresar su contraseña: ")  
        print("DATOS REGISTRADOS CORRECTAMENTE") 
         
    def validacion_dni(self):
        while len(self.__dni)!=8 or self.__dni in Registro.dnisregistrados:
            print("ERROR: Cantidad de digitos erroneos o dni ya registrado. ")
            self.__dni=input("Vuelva a ingresar su dni: ")
class Iniciar_sesion:
    dni=""
    contraseña=""
    condicion=False
    indice=0
    condicion2=False
    contadorb=0
    def __init__(self,lista):
        self.lista=list(lista)
        self.Iniciar()
        contadorb=0
        algo=0
        
        while (algo!=1):
            if Iniciar_sesion.condicion==True:
                    if Iniciar_sesion.condicion2==True:
                        print("Sesion iniciada correctamente, iniciando menú de inicio en 3 segundos")
                        algo=1
                        sleep(3)
                        system("cls")
                        self.menuinic()
                    else:
                        Iniciar_sesion.contadorb+=1
                        self.Bloqueo()
                        print("USUARIO INCORRECTO, VUELVA A INGRESAR")
                        self.Iniciar()
            else:
                Iniciar_sesion.contadorb+=1
                self.Bloqueo()
                print("USUARIO INCORRECTO, VUELVA A INGRESAR")
                self.Iniciar()
        Iniciar_sesion.condicion=False
        Iniciar_sesion.condicion2=False
    def Iniciar(self):
        print("INICIAR SESION".center(30,"="))
        Iniciar_sesion.dni=input("Ingrese su N° de dni: ")
        Iniciar_sesion.contraseña=input("Ingrese su contraseña: ")
        self.verificar()
    def verificar(self):
        for i in range(len(lista)):
            for j in range(2):
                if (Iniciar_sesion.dni==self.lista[i][j]):
                    Iniciar_sesion.condicion=True
                    Iniciar_sesion.indice=i
                    if (Iniciar_sesion.contraseña==self.lista[Iniciar_sesion.indice][1]):
                        Iniciar_sesion.condicion2=True 
    def Bloqueo(self):
        if Iniciar_sesion.contadorb==3:
            print("MUCHOS INTENTOS, HA SIDO BLOQUEADO DEL SISTEMA")
            print("EN UNOS SEGUNDOS SE CERRARÁ EL SISTEMA")
            sleep(2)
            exit()
    def menuinic(self):
        system("cls")
        print("MENÚ DE INICIO DE SESIÓN".center(30,"="))
        print("1. Registro de Defunciones")
        print("2. Contactar con el administrador")
        print("3. Salir")
        self.op=int(input("Elija su opción (1-3): "))
        while(self.op!=1 and self.op!=2 and self.op!=3):
            print("Ingrese una opción Válida")
            sleep(2)
            system("cls")
            print("1. Registro de Defunciones")
            print("2. Contactar con el administrador")
            print("3. Salir")
            self.op=int(input("Elija su opción (1-3): "))
        self.opciones()
        system("cls")

    def opciones(self):
        if(self.op==1):
            print("A continuación ingrese los datos del fallecido: ")
            self.nombrefallecido=input(" Nombre: ")
            self.apaternofallecido=input(" Apellido Paterno: ")
            self.amaternofallecido=input(" Apellido Materno: ")
            self.dnifallecido=input(" Dni: ")
            self.diafallecido=input(" Día de muerte: ")
            self.razonfallecido=input(" Razón de muerte: ")
            self.certificadofallecido=input(" Código del Certificado:")
            print("Ahora sus datos: ")
            self.nombreingresante = input(" Ingrese su nombre: ")
            self.dniingresante=input(" Ingrese su DNI: ")

            self.mensaje = f"Yo {self.nombreingresante} con DNI {self.dniingresante} certifico que la siguiente información es verdadera sobre el fallecido: \n→ Nombre fallecido: {self.nombrefallecido}\n→ Apellido Paterno del fallecido: {self.apaternofallecido}\n→ Apellido Materno del fallecido: {self.amaternofallecido} \n→ Dni del fallecido: {self.dnifallecido}\n→ Día de muerte del fallecido: {self.diafallecido}\n→ Razón de muerte del fallecido: {self.razonfallecido}\n→ Código de Certificado de Defunción: {self.certificadofallecido} "

            self.verificaciónadmin()


        elif(self.op==2):
            online=randint(1,10)
            print("Contamos con ", online," administradores en línea:")
            self.administradores= [["Gianfranco Flores","956231660","sinadef_flores@gmail.com"],
            ["Rodrigo Aspilcueta","978059222","sinadef_aspilcueta@gmail.com"],
            ["Joel Falla","980266408","sinadef_falla@gmail.com"],
            ["Diego Toledo","963699784","sinadef_toledo@gmail.com"],
            ["Juan Cortez","913886189","sinadef_cortez@gmail.com"],
            ["Javier Ancajima","980645392","sinadef_ancajima@gmail.com"],
            ["Alisari Guerra","981606106","sinadef_guerra@gmail.com"],
            ["Andrea Loro","960746130","sinadef_loro@gmail.com"],
            ["Christian Tinco","955195381","sinadef_tinco@gmail.com"],
            ["Jhonatan Alfaro","964932969","sinadef_alfaro@gmail.com"]]
            a=sample(self.administradores,online)
            for i in range(online):
                for j in range(1):
                    print("Administrador ",i+1," :",a[i][j])
            print("¿Con qué administrador desea contactar? (1-",online,")") 
            self.adminelegido=int(input("Elija un administrador: "))
            while(self.adminelegido<1 and self.adminelegido>online):
                print("Ingrese una opción válida.")
                sleep(1)
                system("cls")
                for i in range(online):
                    for j in range(1):
                        print("Administrador ",i+1," :",a[i][j])
                print("¿Con qué administrador desea contactar? (1-",online) 
                self.adminelegido=int(input("Elija un administrador: "))
            print("Estos son los datos del administrador elegido:")
            print("Nombre: ",a[self.adminelegido-1][0])
            print("Teléfono: ",a[self.adminelegido-1][1])
            print("Correo: ",a[self.adminelegido-1][2])
            print("\nEn 5 segundos se volverá al menú de inicio...")
            sleep(5)
            system("cls")
            print("Volviendo al menú de inicio en 3")
            sleep(1)
            print("                                    2")
            sleep(1)
            print("                                              1")
            self.menuinic()
        else:
            menu()

    def verificaciónadmin(self):
        system("cls")
        print("La siguiente información se enviará a un administrador para poder verificar si es verdadera:")
        print(self.mensaje)
        print("¿Es correcta la información?")
        opc=int(input("1. Sí\n2. No\n "))
        while(opc!=1 and opc!=2):
            print("Opción inválida.")
            sleep(1)
            system("cls")
            print("La siguiente información se enviará a un administrador para poder verificar si es verdadera:")
            print(self.mensaje)
            print("¿Es correcta la información?")
            opc=int(input("1. Sí\n2. No\n "))
        
        if(opc==1):
            self.mensaje = "Enviando el mensaje..."
            self.barra()
            print("¡Se ha enviado correctamente la información! ")
            print(" El administrador encargado enviará su respuesta pronto...")
            print("Recuerda que el acta no será válida hasta que sea verificada.")
            sleep(3)
            system("cls")
            self.verificaciondatosenviados()
            self.impresionacta()
        else:
            self.opciones()

    def verificaciondatosenviados(self):
        if len(str(self.dnifallecido))!=8 or len(str(self.dniingresante))!=8 or self.dniingresante!=Iniciar_sesion.dni:
            print("¡DATOS NO VÁLIDOS!")
            print("¡DATOS NO VÁLIDOS!")
            print("¡DATOS NO VÁLIDOS!")
            print("¡DATOS NO VÁLIDOS!")
            sleep(3)
            system("cls")
            print("Volviendo al menú de inicio en 3")
            sleep(1)
            print("                                    2")
            sleep(1)
            print("                                              1")
            self.menuinic()
        else:
            print("¡VERIFICADO CORRECTAMENTE!")
            print("¡VERIFICADO CORRECTAMENTE!")
            print("¡VERIFICADO CORRECTAMENTE!")
            print("¡VERIFICADO CORRECTAMENTE!")
            sleep(3)
    def impresionacta(self):
        system("cls")
        print("¿Desea imprimir su acta?")
        opcion=int(input("1. Sí\n2. No\n"))
        while(opcion!=1 and opcion!=2):
            print("Opción inválida.")
            sleep(1)
            system("cls")
            print("¿Desea imprimir su acta?")
            opcion=int(input("1. Sí\n2. No\n"))

        if(opcion==1):
            self.mensaje="Imprimiendo...\n\t Conectando con la Impresora"
            self.barra()
            print("Impresión lista, revise su impresora")
            print("Volviendo al menú de inicio en 3")
            sleep(1)
            print("                                    2")
            sleep(1)
            print("                                              1")
            self.menuinic()
        else:
            self.menuinic()

    def barra(self):
        def progress_bar(part,total,length=30):
            frac=part/total
            completed = int(frac*length)
            missing=length-completed
            bar=f"[{'█' * completed} {'-'*missing}]{frac:.2%}"
            return bar
        n=30
        system("cls")
        sleep(0)
        print(self.mensaje)
        for i in range(n+1):
            sleep(0.01)
            print(progress_bar(i,n),end='\r')

        sleep(1)
        system("cls")    


lista=list()
def registrarse():
    a=Registro()
    lista.append([a.getdni(),a.getcontraseña()])
def menu():
    opc=0
    while opc!=3:
        sleep(2)
        system("cls")
        print("============MENU============")
        print("1.REGISTRARSE")
        print("2.INGRESAR")
        print("3.Salir")
        opc=int(input("Ingrese una opción: "))
        if opc==1:
            registrarse()
        elif opc==2:
            usuario=Iniciar_sesion(lista)
        elif opc==3:
            exit()
        else: print("OPCION INCORRECTA")
menu()