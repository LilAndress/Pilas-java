package com.mycompany.pilas;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Pilas {
    private Stack<String> atras;    // Pila para navegar hacia atrás
    private Stack<String> adelante;  // Pila para navegar hacia adelante
    private String paginaActual;     // Página actual

    public Pilas() {
        atras = new Stack<>();
        adelante = new Stack<>();
        paginaActual = null; // Inicialmente no hay página
    }

    // Agregar una nueva página al historial
    public void agregarPagina() {
        String nuevaPagina = JOptionPane.showInputDialog("Introduce el nombre de la nueva página:");
        if (nuevaPagina != null && !nuevaPagina.isEmpty()) {
            if (paginaActual != null) {
                atras.push(paginaActual); // Guardar la página actual en la pila de atrás
            }
            paginaActual = nuevaPagina;  // Establecer la nueva página como la actual
            adelante.clear();            // Limpiar el historial de adelante
            JOptionPane.showMessageDialog(null, "Navegando a: " + nuevaPagina);
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la página no puede estar vacío.");
        }
    }

    // Ir hacia atrás
    public void irAtras() {
        if (!atras.isEmpty()) {
            adelante.push(paginaActual); // Guardar la página actual en la pila de adelante
            paginaActual = atras.pop();   // Volver a la página anterior
            JOptionPane.showMessageDialog(null, "Regresando a: " + paginaActual);
        } else {
            JOptionPane.showMessageDialog(null, "No hay más páginas hacia atrás.");
        }
    }

    // Ir hacia adelante
    public void irAdelante() {
        if (!adelante.isEmpty()) {
            atras.push(paginaActual); // Guardar la página actual en la pila de atrás
            paginaActual = adelante.pop(); // Avanzar a la siguiente página
            JOptionPane.showMessageDialog(null, "Avanzando a: " + paginaActual);
        } else {
            JOptionPane.showMessageDialog(null, "No hay más páginas hacia adelante.");
        }
    }

    // Mostrar la página actual
    public void mostrarPaginaActual() {
        if (paginaActual != null) {
            JOptionPane.showMessageDialog(null, "Página actual: " + paginaActual);
        } else {
            JOptionPane.showMessageDialog(null, "No estás en ninguna página.");
        }
    }

    // Mostrar el historial completo de navegación
    public void mostrarHistorial() {
        StringBuilder historial = new StringBuilder("Historial de navegación:\n");
        for (String pagina : atras) {
            historial.append("- ").append(pagina).append("\n");
        }
        historial.append("Página actual: ").append(paginaActual != null ? paginaActual : "Ninguna").append("\n");
        for (String pagina : adelante) {
            historial.append("- ").append(pagina).append("\n");
        }
        JOptionPane.showMessageDialog(null, historial.toString());
    }

    void navegar(String nuevaPagina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
