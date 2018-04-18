package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Ascensor ascensor1;
        public static Ascensor ascensor2;
        public static Ascensor portero;
        
        public static void turnRight(Robot robot){
            for(int i=0; i<3; i++){
                robot.turnLeft();
            }
        }
                
        public static void regresarAlOrigen(Ascensor robot){
            
//            if (robot.getDirection()==Direction.EAST) {
//                robot.turnLeft();
//                robot.turnLeft();
//            }
//            if (robot.getDirection()==Direction.NORTH) {
//                robot.turnLeft();
//            }
//            if (robot.getDirection()==Direction.SOUTH) {
//                turnRight(robot);
//            }
            while (robot.getDirection()!=Direction.WEST){
                 robot.turnLeft();
            }

            while (robot.getAvenue()!= robot.getAvenidaOrigen() ) {                
                robot.move();
            }
            robot.turnLeft();
            
            while (robot.getStreet()!= robot.getCalleOrigen()) {                
                robot.move();
            }
        }
        
//        public static void revisarSiguientePosicion(Ascensor robot){
//            robot.move();
//            if (robot.canPickThing()==true) {
//                robot.pickThing();
//            }
//            if (robot.canPickThing()==false) {
//                regresarAlOrigen(robot);
//            }
//        }
        
        
        //Este metodo inicializa el movimiento del Ascensor 1, es parcialmente determinista
        //Considero que una buena opción para inicializar el movimiento sería un robot.move() mientras las cosas en el maletero sean ==0
        //Y luego ejecutar el while que recoge las 5 cosas o se interrumpe al encontrar un espacio vacío
        public static void cargarPasajeros(Ascensor robot){
            robot.move();
            robot.move();            
            boolean b = true;
            while(b==true){
                int z = robot.countThingsInBackpack();
                if (robot.canPickThing()!=true) {
                    b=false;
                }
                if (robot.countThingsInBackpack()==5) {
                    b=false;
                }

                if (robot.canPickThing()==true && robot.countThingsInBackpack()<5) {
                    robot.pickThing();
                    robot.move();
                }
            }
            if (b==false){
                regresarAlOrigen(robot);
            }
            
            

        }
        
        public static void createUsuarioPrimerPiso(City city, int posVertical ,int posicionHorizontal, int pisoDestino){
            int yRelativa =0;
            int xRelativa =0;
            Usuario u = new Usuario (city, yRelativa+posVertical, xRelativa+posicionHorizontal, pisoDestino);
            
        }
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            
           // Thing a1 = new Thing( objetos,  1,  6);
//            Thing a2 = new Thing( objetos,  1,  7);
            int yRelativa = 0;
            int xRelativa = 0;
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, -i, xRelativa, Direction.WEST);
            }
            for (int i = 1; i < 10; i++) {
                new Wall(objetos, -i, xRelativa+9, Direction.EAST);
            }
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, yRelativa, i, Direction.SOUTH);
            }
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, yRelativa-9, i, Direction.NORTH);
            }
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            //ascensor3 = new Robot(City aCity, int aStreet, int anAvenue, Direction aDirection) 
            ascensor1 = new Ascensor(objetos, yRelativa,xRelativa,  Direction.EAST,0);
            ascensor2 = new Ascensor(objetos, yRelativa,xRelativa+1, Direction.EAST,0);
            //portero = new Ascensor(objetos, yRelativa,xRelativa+2, Direction.EAST,0);
            
            createUsuarioPrimerPiso(objetos, yRelativa, xRelativa+2,6);
            createUsuarioPrimerPiso(objetos, yRelativa, xRelativa+3,6);
            
            createUsuarioPrimerPiso(objetos, yRelativa, xRelativa+6,6);
            
//            Usuario u1 = new Usuario (objetos, yRelativa, xRelativa+2,6);
//            Usuario u2 = new Usuario (objetos, yRelativa, xRelativa+3,6);
//            Usuario u3 = new Usuario (objetos, yRelativa, xRelativa+4,6);
//            Usuario u4 = new Usuario (objetos, yRelativa, xRelativa+5,6);
//            Usuario u5 = new Usuario (objetos, yRelativa, xRelativa+6,6);
//            Usuario u6 = new Usuario (objetos, yRelativa, xRelativa+7,6);
//            Usuario u7 = new Usuario (objetos, yRelativa, xRelativa+8,6);
//            Usuario u8 = new Usuario (objetos, yRelativa, xRelativa+9,6);
//            Usuario u9 = new Usuario (objetos, yRelativa, xRelativa+10,6);
//            Usuario u10 = new Usuario (objetos, yRelativa, xRelativa+11,6);

            cargarPasajeros(ascensor1);

//            while(ascensor1.getAvenue()!=xRelativa){
//                ascensor1.move();
//            }
//            //turnRight(ascensor1);

            

            while (ascensor1.getDirection()!=Direction.NORTH){
                ascensor1.turnLeft();
            }
            //******DESDE ESTE PUNTO (LINEA 160) HASTA LA LINEA 204 SE HACE EL MOVIMIENTO DE UN USUARIO DE MANERA EXPLICITA
            // Los usuarios que usa están contenidos en las líneas (134-143)
            
//            while((ascensor1.getStreet()*-1)!= u1.getPisoDeseado()){
//                ascensor1.move();                
//            }
//            turnRight(ascensor1);
//            ascensor1.move();
//            ascensor1.move();
//            while(ascensor1.canPickThing()==true){
//                ascensor1.move();
//            }
//            if(ascensor1.canPickThing()==false){
//                ascensor1.putThing();
//            }
//            regresarAlOrigen(ascensor1);
//            
//            while (ascensor1.getDirection()!=Direction.NORTH){
//                ascensor1.turnLeft();
//            }
//            
//            while((ascensor1.getStreet()*-1)!= u2.getPisoDeseado()){
//                ascensor1.move();                
//            }
//            turnRight(ascensor1);
//            ascensor1.move();
//            ascensor1.move();
//            while(ascensor1.canPickThing()==true){
//                ascensor1.move();
//            }
//            if(ascensor1.canPickThing()==false){
//                ascensor1.putThing();
//            }
//            regresarAlOrigen(ascensor1);
//            
//            while((ascensor1.getStreet()*-1)!= u3.getPisoDeseado()){
//                ascensor1.move();                
//            }
//            turnRight(ascensor1);
//            ascensor1.move();
//            ascensor1.move();
//            while(ascensor1.canPickThing()==true){
//                ascensor1.move();
//            }
//            if(ascensor1.canPickThing()==false){
//                ascensor1.putThing();
//            }
//            regresarAlOrigen(ascensor1);
            
            //************************
            
            //public synchronized void
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.
//            for (int i = 0; i < 8; i++) {
//                if(portero.canPickThing()==false){
//                
//                new Thing (objetos, portero.getStreet() , portero.getAvenue());
//                }
//            
//            
//                portero.move();
//            }
//            portero.move();
//            portero.move();
           
            
            

            
            
            
//            //Tomando decisiones, Si puedo tomar un Thing
//            boolean puedeTomar = estudiante.canPickThing();
//            
//            //Tomar un Thing
//            if(puedeTomar == true)
//               estudiante.pickThing();
//            
//            //Especifica el numero de Thing que tiene en robot en el bolso
//            int numeroThings = estudiante.countThingsInBackpack();
//            
//            //Poner Thing, se debe validar que tenga things en el bolso
//            estudiante.putThing();
//                       
//            //Si el frente esta libre de Wall
//            estudiante.frontIsClear();
//            
//            //Invocando una funcion
//            creacionFuncion(4);
//            
//            //Toman un Thing
//            estudiante.pickThing();
//            
//            
	}
//        
//        public static void creacionFuncion(int parametroEntrada){
//            for (int i = 0; i < parametroEntrada; i++) 
//                estudiante.move();
//        }
}

