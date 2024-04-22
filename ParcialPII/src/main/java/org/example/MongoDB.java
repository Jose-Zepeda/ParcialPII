package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {
    static class Nodo {
        Telefono telefono;
        Nodo siguiente;

        Nodo(Telefono telefono) {
            this.telefono = telefono;
            this.siguiente = null;
        }
    }

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    // Método para conectar a la base de datos
    public void conectarMongoDB() {
        try {
            // Conexión a MongoDB
            ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            mongoClient = MongoClients.create(settings);

            // Obtener la base de datos y la colección
            database = mongoClient.getDatabase("TelefonosDB");
            collection = database.getCollection("telefonos");
            System.out.println("Conectado a MongoDB");
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            // Puedes agregar aquí lanzamiento de excepción o manejo adicional si es necesario
        }
    }

    // Método para insertar un documento en la colección
    public void insertDocument(Telefono telefono) {
        try {
            Document doc = new Document("marca", telefono.getMarca())
                    .append("modelo", telefono.getModelo())
                    .append("sistemaOperativo", telefono.getSistemaOperativo())
                    .append("tamanoPantalla", telefono.getTamanoPantalla())
                    .append("memoriaRAM", telefono.getMemoriaRAM())
                    .append("almacenamientoInterno", telefono.getAlmacenamientoInterno())
                    .append("tieneCamara", telefono.isTieneCamara())
                    .append("resolucionCamara", telefono.getResolucionCamara())
                    .append("esSmartphone", telefono.isEsSmartphone())
                    .append("imei", telefono.getImei());
            collection.insertOne(doc);
        } catch (Exception e) {
            System.err.println("Error al insertar documento en MongoDB: " + e.getMessage());
            // Puedes agregar aquí lanzamiento de excepción o manejo adicional si es necesario
        }
    }

    // Método para actualizar un teléfono por su IMEI
    public void actualizarTelefono(String imei, Telefono nuevoTelefono) {
        Document filtro = new Document("imei", imei);
        Document nuevoDocumento = new Document("$set", new Document("marca", nuevoTelefono.getMarca())
                .append("modelo", nuevoTelefono.getModelo())
                .append("sistemaOperativo", nuevoTelefono.getSistemaOperativo())
                .append("tamanoPantalla", nuevoTelefono.getTamanoPantalla())
                .append("memoriaRAM", nuevoTelefono.getMemoriaRAM())
                .append("almacenamientoInterno", nuevoTelefono.getAlmacenamientoInterno())
                .append("tieneCamara", nuevoTelefono.isTieneCamara())
                .append("resolucionCamara", nuevoTelefono.getResolucionCamara())
                .append("esSmartphone", nuevoTelefono.isEsSmartphone())
                .append("imei", nuevoTelefono.getImei()));
        collection.updateOne(filtro, nuevoDocumento);
    }

    // Método para eliminar un teléfono por su IMEI
    public void eliminarTelefonoPorImei(String imei) {
        Document filtro = new Document("imei", imei);
        collection.deleteOne(filtro);
    }

    // Método para imprimir todos los teléfonos de la lista enlazada
    public void imprimirTelefonos(Nodo cabeza) {
        Nodo actual = cabeza;
        while (actual != null) {
            Telefono telefono = actual.telefono;
            System.out.println("Marca: " + telefono.getMarca());
            System.out.println("Modelo: " + telefono.getModelo());
            System.out.println("Sistema Operativo: " + telefono.getSistemaOperativo());
            System.out.println("Tamaño de Pantalla: " + telefono.getTamanoPantalla());
            System.out.println("Memoria RAM: " + telefono.getMemoriaRAM());
            System.out.println("Almacenamiento Interno: " + telefono.getAlmacenamientoInterno());
            System.out.println("Tiene Cámara: " + telefono.isTieneCamara());
            System.out.println("Resolución de Cámara: " + telefono.getResolucionCamara());
            System.out.println("Es Smartphone: " + telefono.isEsSmartphone());
            System.out.println("IMEI: " + telefono.getImei());
            System.out.println("-----------------------------------------");

            actual = actual.siguiente;
        }
    }

    public Nodo readAllDocuments() {
        Nodo cabeza = null;
        Nodo actual = null;
        for (Document doc : collection.find()) {
            Telefono telefono = new Telefono(
                    doc.getString("marca"),
                    doc.getString("modelo"),
                    doc.getString("sistemaOperativo"),
                    doc.getDouble("tamanoPantalla"),
                    doc.getInteger("memoriaRAM"),
                    doc.getInteger("almacenamientoInterno"),
                    doc.getBoolean("tieneCamara"),
                    doc.getInteger("resolucionCamara"),
                    doc.getBoolean("esSmartphone"),
                    doc.getString("imei")
            );

            Nodo nuevoNodo = new Nodo(telefono);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                actual = cabeza;
            } else {
                actual.siguiente = nuevoNodo;
                actual = actual.siguiente;
            }
        }
        return cabeza;
    }

    // Método para desconectar de la base de datos
    public void desconectarMongoDB() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada con MongoDB");
        }
    }
}
