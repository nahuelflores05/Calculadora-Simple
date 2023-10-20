import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalesApp {
    private JFrame frame;
    private DefaultListModel<Animal> animalListModel;
    private JList<Animal> animalList;

    public AnimalesApp() {
        frame = new JFrame("Tipos de animales");
        animalListModel = new DefaultListModel<>();
        animalList = new JList<>(animalListModel);

        // Botones para agregar, editar o eliminar 
        JButton agregarButton = new JButton("Agregar");
        JButton editarButton = new JButton("Editar");
        JButton eliminarButton = new JButton("Eliminar");

        // Formulario
        JTextField nombreField = new JTextField(20);
        JTextField especieField = new JTextField(20);

        // Labels para el formulario
        JLabel nombreLabel = new JLabel("Nombre:");

        // Agregar a la ventana
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(animalList), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.add(agregarButton);
        panelBotones.add(editarButton);
        panelBotones.add(eliminarButton);
        frame.add(panelBotones, BorderLayout.SOUTH);

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(nombreLabel);
        panelFormulario.add(nombreField);
        frame.add(panelFormulario, BorderLayout.NORTH);

        // Eventos
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal nuevoAnimal = new Animal(nombreField.getText());
                animalListModel.addElement(nuevoAnimal);
                nombreField.setText("");
                
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animalSeleccionado = animalList.getSelectedValue();
                if (animalSeleccionado != null) {
                    animalSeleccionado.setNombre(nombreField.getText());
                    animalListModel.setElementAt(animalSeleccionado, animalList.getSelectedIndex());
                    nombreField.setText("");
                    especieField.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = animalList.getSelectedIndex();
                if (selectedIndex != -1) {
                    animalListModel.remove(selectedIndex);
                    nombreField.setText("");
                    especieField.setText("");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnimalesApp();
            }
        });
    }

    static class Animal {
        private String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        @Override
        public String toString() {
            return nombre;
        }
    }
}
