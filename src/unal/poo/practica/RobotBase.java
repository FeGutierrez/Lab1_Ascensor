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
        public static Robot portero;
        
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

        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            
           // Thing a1 = new Thing( objetos,  1,  6);
//            Thing a2 = new Thing( objetos,  1,  7);
            int yRelativa = 0;
            int xRelativa = 0;
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, -i, 0, Direction.WEST);
            }
            for (int i = 1; i < 10; i++) {
                new Wall(objetos, -i, 9, Direction.EAST);
            }
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, 0, i, Direction.SOUTH);
            }
            
            for (int i = 0; i < 10; i++) {
                new Wall(objetos, -9, i, Direction.NORTH);
            }
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            //ascensor3 = new Robot(City aCity, int aStreet, int anAvenue, Direction aDirection) 
            ascensor1 = new Ascensor(objetos, yRelativa,xRelativa,  Direction.EAST,0);
            ascensor2 = new Ascensor(objetos, yRelativa,xRelativa+1, Direction.EAST,0);
            
            Usuario u1 = new Usuario (objetos, yRelativa, xRelativa+5,6);
            
            ascensor1.move();
            
            while(ascensor1.countThingsInBackpack()==0){
                if (ascensor1.canPickThing()==true) {
                    ascensor1.pickThing();
                    ascensor1.turnLeft();
                    ascensor1.turnLeft();
                } else {
                   ascensor1.move();
                }
            }
            while(ascensor1.getAvenue()!=xRelativa){
                ascensor1.move();
            }
            turnRight(ascensor1);
            
            while((ascensor1.getStreet()*-1)!= u1.getPisoDeseado()){
                ascensor1.move();                
            }
            
            turnRight(ascensor1);
            ascensor1.move();
            ascensor1.move();
            while(ascensor1.canPickThing()==true){
                ascensor1.move();
            }
            if(ascensor1.canPickThing()==false){
                ascensor1.putThing();
            }
            regresarAlOrigen(ascensor1);
            
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

