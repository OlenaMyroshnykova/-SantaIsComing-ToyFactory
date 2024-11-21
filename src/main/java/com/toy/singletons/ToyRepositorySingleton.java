package com.toy.singletons;

import com.toy.repository.ToyRepository;

public class ToyRepositorySingleton {

    // Eager iniatialization
    /*
     * ¿Cuándo utilizar la inicialización eager?
     * Acceso frecuente: Si se espera que la instancia del singleton sea accedida
     * con mucha frecuencia desde el inicio de la aplicación, la inicialización
     * eager puede mejorar el rendimiento al evitar la sobrecarga de crear la
     * instancia en cada solicitud.
     * Inicialización costosa: Si el proceso de creación de la instancia es costoso
     * en términos de tiempo o recursos, la inicialización eager puede ser
     * beneficiosa al realizar esta tarea una sola vez al inicio de la aplicación.
     * Garantías de disponibilidad: En algunos casos, es crítico que la instancia
     * del singleton esté siempre disponible y accesible, incluso antes de la
     * primera solicitud.
     */
    private static final ToyRepository INSTANCE = new ToyRepository();

    private ToyRepositorySingleton() {}

    public static ToyRepository getInstance() {
        return INSTANCE;
    }

}
