public class Inicio {
    public static void main(String []args){
        
        /*Gato gato=new Gato();
        Perro perro=new Perro();
        Animal animal=new Animal();
        
        System.out.println(animal instanceof Object);*/
        
        Animal []a={new Animal(), new Perro(), new Animal()};
        for(Animal animal: a){
            animal.makeNoise();
            if(animal instanceof Perro){
                Perro p=(Perro)animal;
                p.playDead();
            }
        }
    }
}
