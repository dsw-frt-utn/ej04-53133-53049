package data;
import domain.*;
import java.util.ArrayList;
import java.util.Optional;

public class Persistencia {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Responsable> responsables = new ArrayList<>();
    private static ArrayList<Sucursal> sucursales = new ArrayList<>();
    private static ArrayList<Marca> marcas = new ArrayList<>();

    private static void inicializarResponsables(){
        responsables.add(new Responsable("Carlos Gómez", "25444111", "3815551111"));
        responsables.add(new Responsable("Laura Pérez", "30111222", "3815552222"));
    }

    private static void inicializarSucursales(){
        sucursales.add(new Sucursal("SUC01", "Av. Belgrano 1200", "Tucumán", responsables.get(0)));
        sucursales.add(new Sucursal("SUC02", "San Martín 450", "Yerba Buena", responsables.get(1)));
    }

    private static void inicializarMarcas(){
        marcas.add(new Marca("Renault", "Francia"));
        marcas.add(new Marca("Ford", "Estados Unidos"));
        marcas.add(new Marca("Iveco", "Italia"));
        marcas.add(new Marca("Mercedes", "Alemania"));
        marcas.add(new Marca("Toyota", "Japón"));
    }

    // Los vehículos ya NO se crean por código
    public static ArrayList<Vehiculo> getVehiculos() { return vehiculos; }
    public static ArrayList<Sucursal> getSucursales() { return sucursales; }
    public static ArrayList<Marca> getMarcas() { return marcas; }

    public static Optional<Vehiculo> getVehiculo(String patente){
        return vehiculos.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst();
    }

    public static void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public static void inicializar(){
        inicializarResponsables();
        inicializarSucursales();
        inicializarMarcas();
    }
}