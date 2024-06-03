import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleados{
    public int id;
    public String name;
    public String email;
    public String puesto;

    public int horas;
    
    public Empleados(int id,String name,String email,String puesto){
        this.id=id;
        this.name=name;
        this.email=email;
        this.puesto=puesto;
    }
    public void describir(){
        System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);

    }
    public void calcularGanancias(){
        System.out.println("El empleado: "+name+" gana x");
    }
}

public class Gerente extends  Empleados{
    public int nominaGerente=2137;

    public Gerente(int id,String name, String email){
        super(id,name,email,"Gerente");
    }
    @Override
    public void describir(){
        System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
    }
    @Override
    public void calcularGanancias(){

        System.out.println("El empleado: "+name+ "gana "+nominaGerente+" bonificaciones");
    }
}

 class Ingenieros extends Empleados{
    Scanner scanner=new Scanner(System.in);

    public Ingenieros(int id, String name, String email){
        super(id,name,email,"Ingeniero");
    }
    @Override
    public void describir(){
        System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
    }
    @Override
    public void calcularGanancias(){
        System.out.println("Escriba el precio la hora del ingeniero");
        int nominaHorasIngenieros=scanner.nextInt();
        System.out.println("Escriba las horas trabajadas");
        int horas=scanner.nextInt();
        int nominaFinal=nominaHorasIngenieros*horas;
        System.out.println("El empleado: "+name+ " gana "+nominaFinal);
    }
}

 class Administrativo extends Empleados{
    /*Scanner scanner=new Scanner(System.in);
    int nominaHorasAdministrativo=scanner.nextInt();
    int horas=scanner.nextInt();
    int nominaFinal=nominaHorasAdministrativo*horas;*/

    public Administrativo (int id, String name,String email){
        super(id,name,email,"Administrativo");
    }
    @Override
    public void describir(){
        System.out.println("Empleado: "+id+" Nombre: "+name+" Puesto: "+puesto+" Email: "+email);
    }
    @Override
    public void calcularGanancias(){
        System.out.println("El empleado: "+name+ " gana ");
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
        }
    }
}
 class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        Gerente gerente1 = new Gerente(1, "Juan", "juan@example.com");
        Ingenieros ingeniero1 = new Ingenieros(2, "Pedro", "pedro@example.com");
        Administrativo administrativo1 = new Administrativo(3, "Maria", "maria@example.com");

        empresa.agregarEmpleado(gerente1);
        empresa.agregarEmpleado(ingeniero1);
        empresa.agregarEmpleado(administrativo1);

        empresa.mostrarEmpleados();
    }
}