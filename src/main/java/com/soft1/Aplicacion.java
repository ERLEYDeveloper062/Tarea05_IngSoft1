package com.soft1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Aplicacion {

    private JFrame frame;
    private ControlBanda controlBanda; 
    private ControlAlbum controlAlbum;
    private ControlConcierto controlConcierto;

    public Aplicacion() {
        controlBanda = new ControlBanda();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Rock & Code");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton btnBanda = new JButton("Banda");
        JButton btnAlbum = new JButton("Álbum");

        btnBanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOpcionesBanda();
            }
        });

        btnAlbum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOpcionesAlbum();
            }
        });

        frame.getContentPane().add(btnBanda);
        frame.getContentPane().add(btnAlbum);
        frame.setVisible(true);
    }

    private void mostrarOpcionesBanda() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JButton btnRegistrarBanda = new JButton("Registrar Banda");
        btnRegistrarBanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarBanda();
            }
        });

        JButton btnActualizarBanda = new JButton("Actualizar Banda");
        btnActualizarBanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarBanda();
            }
        });

        JButton btnConsultarBanda = new JButton("Consultar Banda");
        btnConsultarBanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarBanda();
            }
        });

        JButton btnAgregarMiembro = new JButton("Agregar Miembro");
        btnAgregarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMiembro();
            }
        });

        frame.getContentPane().add(btnRegistrarBanda);
        frame.getContentPane().add(btnActualizarBanda);
        frame.getContentPane().add(btnConsultarBanda);
        frame.getContentPane().add(btnAgregarMiembro);
        frame.validate();
    }

    private void mostrarOpcionesAlbum() {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Agregar botones para las opciones de Álbum aquí...

        frame.validate();
    }

    private void registrarBanda() {
        JFrame registroFrame = new JFrame("Registrar Banda");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtGenero = new JTextField();
        JSpinner dateFechaCreacion = new JSpinner(new SpinnerDateModel());
        JTextField txtFotos = new JTextField(); // Podrías querer cambiar esto para manejar múltiples fotos

        registroFrame.add(new JLabel("Nombre:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Género:"));
        registroFrame.add(txtGenero);
        registroFrame.add(new JLabel("Fecha de Creación:"));
        registroFrame.add(dateFechaCreacion);
        registroFrame.add(new JLabel("Fotos (separadas por comas):"));
        registroFrame.add(txtFotos);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí recoges la información de los campos y creas una banda
                String nombre = txtNombre.getText();
                String genero = txtGenero.getText();
                Date fechaCreacion = (Date) dateFechaCreacion.getValue();
                ArrayList<String> fotos = new ArrayList<>(); // Necesitas procesar txtFotos para convertirlo en una lista

                Banda banda = new Banda(nombre, genero, fechaCreacion, fotos);
                controlBanda.registrarBanda(banda);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    public void ActualizarBanda(){
        JFrame registroFrame = new JFrame("Actualizar Banda");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtGenero = new JTextField();
        JSpinner dateFechaCreacion = new JSpinner(new SpinnerDateModel());
        JTextField txtFotos = new JTextField(); // Podrías querer cambiar esto para manejar múltiples fotos

        registroFrame.add(new JLabel("Nombre:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Género:"));
        registroFrame.add(txtGenero);
        registroFrame.add(new JLabel("Fecha de Creación:"));
        registroFrame.add(dateFechaCreacion);
        registroFrame.add(new JLabel("Fotos (separadas por comas):"));
        registroFrame.add(txtFotos);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí recoges la información de los campos y creas una banda
                String nombre = txtNombre.getText();
                String genero = txtGenero.getText();
                Date fechaCreacion = (Date) dateFechaCreacion.getValue();
                ArrayList<String> fotos = new ArrayList<>(); // Necesitas procesar txtFotos para convertirlo en una lista

                Banda banda = new Banda(nombre, genero, fechaCreacion, fotos);
                controlBanda.actualizarBanda(banda);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    private void consultarBanda() {
        String nombreBanda = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la banda:");
        if (nombreBanda != null && !nombreBanda.trim().isEmpty()) {
            String infoBanda = controlBanda.consultarBanda(nombreBanda);
            JOptionPane.showMessageDialog(frame, infoBanda);
        } else {
            JOptionPane.showMessageDialog(frame, "No se ingresó un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarMiembro() {
        JFrame registroFrame = new JFrame("Agregar Miembro");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombreBanda = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtRol = new JTextField();
        JTextField txtInstrumentos= new JTextField(); // Podrías querer cambiar esto para manejar múltiples fotos

        registroFrame.add(new JLabel("Nombre Banda:"));
        registroFrame.add(txtNombreBanda);
        registroFrame.add(new JLabel("Nombre:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Rol:"));
        registroFrame.add(txtRol);
        registroFrame.add(new JLabel("Instrumentos (separados por comas):"));
        registroFrame.add(txtInstrumentos);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí recoges la información de los campos y creas una banda
                String nombreBanda = txtNombreBanda.getText();
                String nombre = txtNombre.getText();
                String rol = txtRol.getText();
                String instrumentos = txtInstrumentos.getText();
                instrumentos = instrumentos.toUpperCase();

                String[] instrumentoList = instrumentos.split(",");
                Set<Instrumento> instrumentosSet = new HashSet<>();

                for(String elemento : instrumentoList){
                    try {
                        instrumentosSet.add(Instrumento.valueOf(elemento));
                    } catch (IllegalArgumentException error) {
                        JOptionPane.showMessageDialog(null,elemento + "No es un instrumento valido");
                    }
                }

                Miembro miembro = new Miembro(nombre, rol, instrumentosSet);
                Banda banda = controlBanda.buscarBanda(nombreBanda);
                banda.agregarMiembro(miembro);
                registroFrame.dispose(); 
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Aplicacion window = new Aplicacion();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

