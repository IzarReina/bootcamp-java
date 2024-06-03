import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleados{
    public int id;
    public String name;
    public String email;
    public String puesto;

    public int nomina;
    public int precioHoras;
    public int horas;
    
    public Empleados(int id,String name,String email,String puesto,int nomina, int precioHoras,int horas){
        this.id=id;
        this.name=name;
        this.email=email;
        this.puesto=puesto;
        this.nomina=nomina;
        this.precioHoras=precioHoras;
        this.horas=horas;
    }
    public void describir(){
        System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);

    }
    public void calcularGanancias(){
        System.out.println("Nomina "+nomina+(precioHoras*horas));
    }
}
 
    public class Gerente extends  Empleados{

        public Gerente(int id,String name, String email,int nomina){
            super(id,name,email,"Gerente",2550,0,0);
            
        }

        @Override
        public void describir(){
            System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
        }
    
        public void calcularGanancias(){

            System.out.println("El empleado: "+name+ " gana "+nomina+" + bonificaciones");
        }
    }      

    class Ingenieros extends Empleados{

        public Ingenieros(int id, String name, String email, int nomina, int precioHoras, int horas){
            super(id,name,email,"Ingeniero",0,22,120);
        }
        @Override
        public void describir(){
            System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
        }

        public void calcularGanancias(){
             nomina=precioHoras*horas;
            System.out.println("El empleado: "+name+ " gana "+nomina);
        }
    }

    class Administrativo extends Empleados{

        public Administrativo (int id, String name,String email,int nomina, int precioHoras,int horas){
            super(id,name,email,"Administrativo",0,16,120);
        }
        @Override
        public void describir(){
            System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
        }
    
        public void calcularGanancias(){
            nomina=precioHoras*horas;
            System.out.println("El empleado: "+name+ " gana "+nomina);
        }
    }

    class Empresa{
        List<Empleados>empleados;

        public Empresa(){
            this.empleados=new ArrayList<>();
        }
        public void agregarEmpleado(Empleados empleado){
            empleados.add(empleado);
        }
        public void mostrarEmpleados(){
            
            for(Empleados empleado:empleados){
                empleado.describir();
                empleado.calcularGanancias();
            }
        }
        public void buscarEmpleado(String nombreEmpleado){
            for(Empleados empleado:empleados){
                if(empleado.name.equalsIgnoreCase(nombreEmpleado)){
                    empleado.describir();
                    empleado.calcularGanancias();
                    return;
                }
            }
        }
    }
    class Main {
        public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
            String nombreEmpleado=scanner.next();
           
            Empresa empresa = new Empresa();

            Gerente gerente1 = new Gerente(1, "Juan", "juan@example.com",0);
            Ingenieros ingeniero1 = new Ingenieros(2, "Pedro", "pedro@example.com",0,0,0);
            Administrativo administrativo1 = new Administrativo(3, "Maria", "maria@example.com",0,0,0);

            empresa.agregarEmpleado(gerente1);
            empresa.agregarEmpleado(ingeniero1);
            empresa.agregarEmpleado(administrativo1);

            empresa.buscarEmpleado(nombreEmpleado);
        }
    }
