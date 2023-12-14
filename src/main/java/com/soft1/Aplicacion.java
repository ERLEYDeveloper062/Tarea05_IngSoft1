package com.soft1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.NoSuchElementException;

public class Aplicacion {

    private JFrame frame;
    private ControlBanda controlBanda;
    private ControlAlbum controlAlbum;
    private ControlConcierto controlConcierto;

    public Aplicacion() {
        controlBanda = new ControlBanda();
        controlAlbum = new ControlAlbum();
        controlConcierto = new ControlConcierto();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Rock & Code");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton btnBanda = new JButton("Banda");
        JButton btnAlbum = new JButton("Álbum");
        JButton btnConcierto = new JButton("Concierto");

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

        btnConcierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarOpcionesConcierto();
            }
        });

        frame.getContentPane().add(btnBanda);
        frame.getContentPane().add(btnAlbum);
        frame.getContentPane().add(btnConcierto);
        frame.setVisible(true);
    }

    /*----------------------------------------------------------------------------------------------*/
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

        JButton btnRegistarAlbum = new JButton("Regitro Album");
        btnRegistarAlbum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registarAlbum();
            }
        });

        JButton btnAgregarCanciones = new JButton("Agregar Canciones");
        btnAgregarCanciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCanciones();
            }
        });

        JButton btnBuscarAlbum = new JButton("Buscar Album");
        btnBuscarAlbum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAlbum();
            }
        });

        JButton btnBuscarCancion = new JButton("Buscar Cancion");
        btnBuscarCancion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCancion();
            }
        });

        JButton btnConsultarAlbum = new JButton("Consultar Album");
        btnConsultarAlbum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAlbum();
            }
        });

        frame.getContentPane().add(btnRegistarAlbum);
        frame.getContentPane().add(btnAgregarCanciones);
        frame.getContentPane().add(btnBuscarAlbum);
        frame.getContentPane().add(btnBuscarCancion);
        frame.getContentPane().add(btnConsultarAlbum);
        frame.validate();

        frame.validate();

        frame.validate();
    }

    private void mostrarOpcionesConcierto() {
        frame.getContentPane().removeAll();
        frame.repaint();

        frame.getContentPane().removeAll();
        frame.repaint();

        JButton btnAgregarConcierto = new JButton("Agregar Concierto");
        btnAgregarConcierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarConcierto();
            }
        });

        JButton btnSeleccionarConcierto = new JButton("Seleccionar Concierto");
        btnSeleccionarConcierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarConcierto();
            }
        });

        JButton btnRegistrarBoletosVendidos = new JButton("Registrar Boletos Vendidos");
        btnRegistrarBoletosVendidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarBoletosVendidos();
            }
        });

        JButton btnConsultarConcierto = new JButton("Consultar Conciertos");
        btnConsultarConcierto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cosultarConciertos();
            }
        });

        JButton btnObtenerCanciones = new JButton("Obtener Canciones del Concierto");
        btnObtenerCanciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarConciertoPorNombre();
            }
        });

        frame.getContentPane().add(btnAgregarConcierto);
        frame.getContentPane().add(btnSeleccionarConcierto);
        frame.getContentPane().add(btnRegistrarBoletosVendidos);
        frame.getContentPane().add(btnConsultarConcierto);
        frame.getContentPane().add(btnObtenerCanciones);
        frame.validate();
    }

    /*---------------------------------------------------------------------------------------------------------------------------- */
    private void registrarBanda() {
        JFrame registroFrame = new JFrame("Registrar Banda");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtGenero = new JTextField();
        JSpinner dateFechaCreacion = new JSpinner(new SpinnerDateModel());
        JTextField txtFotos = new JTextField(); // Podrías querer cambiar esto para manejar múltiples fotos

        registroFrame.add(new JLabel("Nombre De la Banda:"));
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
                ArrayList<String> fotos = new ArrayList<>(); // Necesitas procesar txtFotos para convertirlo en una
                                                             // lista

                Banda banda = new Banda(nombre, genero, fechaCreacion, fotos);
                controlBanda.registrarBanda(banda);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    public void ActualizarBanda() {
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
                ArrayList<String> fotos = new ArrayList<>(); // Necesitas procesar txtFotos para convertirlo en una
                                                             // lista

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
        JTextField txtInstrumentos = new JTextField(); // Podrías querer cambiar esto para manejar múltiples fotos

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

                for (String elemento : instrumentoList) {
                    try {
                        instrumentosSet.add(Instrumento.valueOf(elemento));
                    } catch (IllegalArgumentException error) {
                        JOptionPane.showMessageDialog(null, elemento + "No es un instrumento valido");
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

    /*----------------------------------------------------------------------------------------- */
    private void agregarConcierto() {
        JFrame registroFrame = new JFrame("AgregarConcierto");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JSpinner dateFechaCreacion = new JSpinner(new SpinnerDateModel());

        registroFrame.add(new JLabel("Nombre del Concierto:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Fecha de Creación:"));
        registroFrame.add(dateFechaCreacion);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí recoges la información de los campos y creas una banda
                String nombre = txtNombre.getText();
                Date fechaCreacion = (Date) dateFechaCreacion.getValue();

                Concierto concierto = new Concierto(nombre, fechaCreacion);
                System.out.println(concierto.getNombre());
                controlConcierto.agregarConcierto(concierto);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    private void registrarBoletosVendidos() {
        JFrame registroFrame = new JFrame("RegistrarBoletosVendidos");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtCantidad = new JTextField();

        registroFrame.add(new JLabel("Nombre del Concierto:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Cantidad de boletos:"));
        registroFrame.add(txtCantidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí recoges la información de los campos y creas una banda
                String nombre = txtNombre.getText();
                int cantidad = 0; // Valor por defecto en caso de error al convertir a entero

                try {
                    cantidad = Integer.parseInt(txtCantidad.getText());
                } catch (NumberFormatException ex) {
                    // Manejo de error si la entrada no es un número válido
                    ex.printStackTrace();
                    // Puedes mostrar un mensaje al usuario indicando que la cantidad no es válida
                }

                controlConcierto.registrarBoletosVendidos(nombre, cantidad);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    private String obtenerInformacionConciertos() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Guardar el System.out en una variable temporal
        PrintStream oldOut = System.out;

        // Redirigir System.out a nuestro PrintStream
        System.setOut(printStream);

        // Llamar al método que imprime en la consola
        controlConcierto.consultarConciertos();

        // Restaurar el System.out original
        System.setOut(oldOut);

        // Obtener la información de los conciertos del outputStream
        return outputStream.toString();
    }

    private void cosultarConciertos() {
        String informacionConciertos = obtenerInformacionConciertos();

        // Mostrar la información en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, informacionConciertos, "Información de Conciertos: ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void seleccionarConcierto() {
        JFrame frame = new JFrame("Seleccionar Concierto");
        frame.setSize(500, 400);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JComboBox<String> concertComboBox = new JComboBox<>();
        // Assuming you have a method to get all concert names
        for (String concertName : controlConcierto.getAllConcertNames()) {
            concertComboBox.addItem(concertName);
        }

        JTextArea songNameArea = new JTextArea(10, 20);
        songNameArea.setBorder(BorderFactory.createTitledBorder("Nombres de Canciones"));
        JScrollPane scrollPaneNames = new JScrollPane(songNameArea);

        JTextArea songDurationArea = new JTextArea(10, 20);
        songDurationArea.setBorder(BorderFactory.createTitledBorder("Duraciones (minutos)"));
        JScrollPane scrollPaneDurations = new JScrollPane(songDurationArea);

        JButton submitButton = new JButton("Agregar Canciones");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedConcert = (String) concertComboBox.getSelectedItem();
                List<Cancion> canciones = new ArrayList<>();
                String[] songNames = songNameArea.getText().split("\\n");
                String[] songDurations = songDurationArea.getText().split("\\n");

                if (songNames.length != songDurations.length) {
                    JOptionPane.showMessageDialog(frame, "El número de canciones y duraciones no coincide.");
                    return;
                }

                try {
                    for (int i = 0; i < songNames.length; i++) {
                        double duration = Double.parseDouble(songDurations[i]);
                        canciones.add(new Cancion(songNames[i], duration));
                    }
                    controlConcierto.seleccionarConcierto(selectedConcert, canciones);
                    JOptionPane.showMessageDialog(frame, "Canciones agregadas al concierto.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error en el formato de las duraciones.");
                }
            }
        });

        frame.add(concertComboBox);
        frame.add(scrollPaneNames);
        frame.add(scrollPaneDurations);
        frame.add(submitButton);

        frame.setVisible(true);
    }

    private void consultarConciertoPorNombre() {
        String nombreConcierto = JOptionPane.showInputDialog(frame, "Ingrese el nombre del Concierto:");
        if (nombreConcierto != null && !nombreConcierto.trim().isEmpty()) {
            try {
                List<Cancion> canciones = controlConcierto.getCancionesPorConcierto(nombreConcierto);

                StringBuilder cancionesStr = new StringBuilder("Canciones del Concierto " + nombreConcierto + ":\n");
                for (Cancion cancion : canciones) {
                    cancionesStr.append(cancion.getNombre()).append(" - Duración: ")
                            .append(cancion.getDuracion()).append(" minutos\n");
                }

                JOptionPane.showMessageDialog(frame, cancionesStr.toString());
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(frame, "No se encontró el concierto: " + nombreConcierto, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No se ingresó un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * --------------------------------------------------------------------------------------
     */

    private void registarAlbum() {
        JFrame registroFrame = new JFrame("Registrar Album");
        registroFrame.setBounds(100, 100, 450, 300);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNombre = new JTextField();
        JSpinner dateFechaCreacion = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateFechaCreacion, "dd/MM/yyyy");
        dateFechaCreacion.setEditor(dateEditor);

        JTextArea txtCanciones = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(txtCanciones);

        registroFrame.add(new JLabel("Nombre Del Album:"));
        registroFrame.add(txtNombre);
        registroFrame.add(new JLabel("Fecha de Creación:"));
        registroFrame.add(dateFechaCreacion);
        registroFrame.add(new JLabel("Canciones (nombre-duración):"));
        registroFrame.add(scrollPane);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                Date fechaCreacion = (Date) dateFechaCreacion.getValue();
                List<Cancion> canciones = new ArrayList<>();

                String[] cancionesInput = txtCanciones.getText().split("\\n");
                for (String cancionInfo : cancionesInput) {
                    String[] parts = cancionInfo.split("-");
                    if (parts.length == 2) {
                        try {
                            String nombreCancion = parts[0].trim();
                            double duracion = Double.parseDouble(parts[1].trim());
                            canciones.add(new Cancion(nombreCancion, duracion));
                        } catch (NumberFormatException ex) {
                            // Handle parsing error
                        }
                    }
                }

                Album album = new Album(nombre, fechaCreacion, canciones);
                controlAlbum.registrarAlbum(album);
                registroFrame.dispose(); // Cierra la ventana de registro
            }
        });

        registroFrame.add(btnGuardar);
        registroFrame.setVisible(true);
    }

    private void agregarCanciones() {
        JFrame frame = new JFrame("Agregar Canciones");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2));

        JComboBox<String> albumComboBox = new JComboBox<>();
        // Assuming you have a method to get all album names
        for (Album nombreAlbum : controlAlbum.getAlbumes()) {
            albumComboBox.addItem(nombreAlbum.getNombre());
        }

        JTextArea txtCanciones = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(txtCanciones);

        frame.add(new JLabel("Seleccionar Album:"));
        frame.add(albumComboBox);
        frame.add(new JLabel("Canciones (nombre-duración):"));
        frame.add(scrollPane);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAlbum = (String) albumComboBox.getSelectedItem();
                String[] cancionesInput = txtCanciones.getText().split("\\n");
                for (String cancionInfo : cancionesInput) {
                    String[] parts = cancionInfo.split("-");
                    if (parts.length == 2) {
                        try {
                            String nombreCancion = parts[0].trim();
                            double duracion = Double.parseDouble(parts[1].trim());
                            Cancion cancion = new Cancion(nombreCancion, duracion);
                            controlAlbum.agregarCanciones(cancion, selectedAlbum);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Error al parsear la duración de la canción.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(frame, "Canciones agregadas al álbum.");
                frame.dispose();
            }
        });

        frame.add(btnAgregar);
        frame.setVisible(true);
    }


    private void buscarAlbum() {
        JFrame frame = new JFrame("Buscar Album");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(0, 2));

        JTextField txtNombreAlbum = new JTextField();
        frame.add(new JLabel("Nombre del Album:"));
        frame.add(txtNombreAlbum);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlbum = txtNombreAlbum.getText();
                Album album = controlAlbum.buscarAlbum(nombreAlbum); // Assuming controlAlbum has a method buscarAlbum
                if (album != null) {
                    // Display album information
                    String info = "Nombre: " + album.getNombre() + "\n" +
                                  "Fecha: " + album.getFecha() + "\n" +
                                  "Duración: " + album.getDuracion() + "\n";
                    JOptionPane.showMessageDialog(frame, info);
                } else {
                    JOptionPane.showMessageDialog(frame, "Album no encontrado.", "Búsqueda", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(btnBuscar);
        frame.setVisible(true);
    }


    private void buscarCancion() {
        JFrame frame = new JFrame("Buscar Canción");
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(0, 2));

        JTextField txtNombreCancion = new JTextField();
        frame.add(new JLabel("Nombre de la Canción:"));
        frame.add(txtNombreCancion);

        JTextField txtNombreAlbum = new JTextField();
        frame.add(new JLabel("Nombre del Álbum:"));
        frame.add(txtNombreAlbum);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCancion = txtNombreCancion.getText();
                String nombreAlbum = txtNombreAlbum.getText();

                try {
                    if (controlAlbum.buscarCancion(nombreCancion, nombreAlbum)) {
                        JOptionPane.showMessageDialog(frame, "La canción '" + nombreCancion + "' se encuentra en el álbum '" + nombreAlbum + "'.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "La canción no se encuentra en el álbum especificado.", "Búsqueda", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(btnBuscar);
        frame.setVisible(true);
    }

    private void consultarAlbum() {
        JFrame frame = new JFrame("Consultar Álbum");
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(0, 2));

        JTextField txtNombreAlbum = new JTextField();
        frame.add(new JLabel("Nombre del Álbum:"));
        frame.add(txtNombreAlbum);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAlbum = txtNombreAlbum.getText();
                String resultado = controlAlbum.consultarAlbum(nombreAlbum);
                JOptionPane.showMessageDialog(frame, resultado);
            }
        });

        frame.add(btnConsultar);
        frame.setVisible(true);
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
