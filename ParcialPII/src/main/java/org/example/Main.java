package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de MongoDB
        MongoDB mongoDB = new MongoDB();

        // Conectar a la base de datos de MongoDB
        mongoDB.conectarMongoDB();

        // Insertar un documento en la colección
//        Telefono telefono1 = new Telefono("Samsung", "Galaxy S20", "Android", 6.2, 8, 128, true, 64, true, "123456789012345");
//        mongoDB.insertDocument(telefono1);

        // Leer todos los documentos de la colección y almacenarlos en una lista enlazada
        MongoDB.Nodo cabeza = mongoDB.readAllDocuments();

        // Imprimir todos los teléfonos de la lista enlazada
        mongoDB.imprimirTelefonos(cabeza);

        // Actualizar un teléfono por su IMEI
        String imei = "123456789012345";
        Telefono nuevoTelefono = new Telefono("Samsung", "Galaxy S21", "Android", 6.5, 8, 256, true, 64, true, "123456789012345");
        mongoDB.actualizarTelefono(imei, nuevoTelefono);

        // Imprimir todos los teléfonos de la lista enlazada después de la actualización
        cabeza = mongoDB.readAllDocuments();
        mongoDB.imprimirTelefonos(cabeza);

        // Eliminar un teléfono por su IMEI
        String imeiAEliminar = "123456789012345";
        mongoDB.eliminarTelefonoPorImei(imeiAEliminar);

        // Imprimir todos los teléfonos de la lista enlazada después de la eliminación
        cabeza = mongoDB.readAllDocuments();
        mongoDB.imprimirTelefonos(cabeza);

        // Cerrar la conexión a la base de datos de MongoDB
        mongoDB.desconectarMongoDB();
    }
}
