package tienda;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Mauricio
 */
public class Clientes extends JFrame implements ActionListener,KeyListener,ItemListener{
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    //Se declaran componentes gráficos
    JLabel titulo,cedula,nombre,apellido,direccion,telefono,genero,email,fecha_ingreso,diag1,diag2;
    JTextField txtcedula,txtnombre,txtapellido,txtdireccion,txttelefono,txtemail,txtdia,txtmes,txtaño;
    JButton buscar,ver_lista,guardar,cancelar,salir;
    JComboBox menu=new JComboBox();
        
    public Clientes(){
        setSize(750,330);//Establecemos el tamaño de la ventana
        setTitle("Clientes");//Establecemos el titulo de la ventana
        setLocationRelativeTo(null);//Establecemos que la ventana aparezca en el centro de la pantalla
        setMinimumSize(new Dimension(750,330));//Se establece el tamaño mínimo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instanciamos los controles gráficos
        titulo=new JLabel("Administrador de Clientes");
        titulo.setForeground(Color.WHITE);
        cedula=new JLabel("Cédula:");
        cedula.setForeground(Color.WHITE);
        nombre=new JLabel("Nombre:");
        nombre.setForeground(Color.WHITE);
        apellido=new JLabel("Apellido:");
        apellido.setForeground(Color.WHITE);
        direccion=new JLabel("Dirección:");
        direccion.setForeground(Color.WHITE);
        telefono=new JLabel("Télefono:");
        telefono.setForeground(Color.WHITE);
        genero=new JLabel("Género:");
        genero.setForeground(Color.WHITE);
        email=new JLabel("Email:");
        email.setForeground(Color.WHITE);
        fecha_ingreso=new JLabel("Fecha de Ingreso:");
        fecha_ingreso.setForeground(Color.WHITE);
        diag1=new JLabel("/");
        diag1.setForeground(Color.WHITE);
        diag2=new JLabel("/");
        diag2.setForeground(Color.WHITE);
        txtcedula=new JTextField(10);
        txtnombre=new JTextField(20);
        txtapellido=new JTextField(20);
        txtdireccion=new JTextField(50);
        txttelefono=new JTextField(12);
        txtemail=new JTextField(30);
        txtdia=new JTextField(2);
        txtmes=new JTextField(2);
        txtaño=new JTextField(4);
        buscar=new JButton("Buscar");
        ver_lista=new JButton("Ver Inscritos");
        guardar=new JButton("Guardar");
        cancelar=new JButton("Cancelar");
        salir=new JButton("Salir");
        eventoOyenteRaton();
        
        //SE AÑADEN LOS STRING AL JComboBox
        menu.addItem("Masculino");
        menu.addItem("Femenino");
        
        //LE INDICAMOS A CADA CONTROL CUAL ES EL OBJETO QUE ADMINISTRARÁ SUS EVENTOS
    	buscar.addActionListener(this);
        ver_lista.addActionListener(this);
        guardar.addActionListener(this);
        cancelar.addActionListener(this);
        salir.addActionListener(this);
        txtcedula.addKeyListener(this);
        txtnombre.addKeyListener(this);
        txtapellido.addKeyListener(this);
        txtdireccion.addKeyListener(this);
        txttelefono.addKeyListener(this);
        txtemail.addKeyListener(this);
        txtdia.addKeyListener(this);
        txtmes.addKeyListener(this);
        txtaño.addKeyListener(this);
        menu.addItemListener(this);
        
        //PREPARACION DE LOS PANELES
        p1=new JPanel();  p2=new JPanel();  p3=new JPanel();  p4=new JPanel();  p5=new JPanel(); p6=new JPanel(); p7=new JPanel(); p8=new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setLayout(new FlowLayout(FlowLayout.LEFT));
        p8.setLayout(new GridLayout(7,1));
        
        //AGREGAMOS LOS CONTROLES A LOS PANELES
        p1.add(titulo);
        p1.setBackground(new Color(0, 102, 102));//Establecemos el color del panel
        p2.add(cedula); p2.add(txtcedula);  p2.add(buscar); p2.add(ver_lista);
        p2.setBackground(new Color(0, 102, 102));
        p3.add(nombre); p3.add(txtnombre);  p3.add(apellido); p3.add(txtapellido);
        p3.setBackground(new Color(0, 102, 102));
        p4.add(direccion); p4.add(txtdireccion);
        p4.setBackground(new Color(0, 102, 102));
        p5.add(telefono); p5.add(txttelefono);  p5.add(email); p5.add(txtemail); p5.add(genero); p5.add(menu);
        p5.setBackground(new Color(0, 102, 102));
        p6.add(txtdia); p6.add(diag1); p6.add(txtmes); p6.add(diag2); p6.add(txtaño);
        p6.setBackground(new Color(0, 102, 102));
        p7.add(fecha_ingreso); p7.add(p6);  p7.add(guardar); p7.add(cancelar); p7.add(salir);
        p7.setBackground(new Color(0, 102, 102));
        
        p8.add(p1);
        p8.add(p2);
        p8.add(p3);
        p8.add(p4);
        p8.add(p5);
        p8.add(p7);
        p8.setBackground(new Color(0, 102, 102));
        
        //OBTENEMOS EL PANEL DE CONTENIDO DE LA VENTANA
        Container mipanel=getContentPane();
        mipanel.setLayout(new BorderLayout());
                
        //AGREGAMOS LOS PANELES AL CONTENEDOR
        mipanel.add(p8,BorderLayout.CENTER);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == salir){	
            Ventana abrir=new Ventana();
            abrir.setVisible(true);
            this.setVisible(false);
	}
        if(ae.getSource() == cancelar){	
            Ventana abrir=new Ventana();
            abrir.setVisible(true);
            this.setVisible(false);
	}
    }    
    
    //CLASE ANONIMA PARA EVENTOS DE RATON
    private void eventoOyenteRaton(){
        MouseListener oyenteDeRaton=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getSource()== buscar){
                    JOptionPane.showMessageDialog(null, "Aún no hay clientes guardados");
	        }
                if(me.getSource()== ver_lista){
                    JOptionPane.showMessageDialog(null, "Aún no hay clientes guardados");
	        }
                if(me.getSource()== guardar){
                    JOptionPane.showMessageDialog(null, "Aún no se pueden guardar datos");
	        }
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        };
        buscar.addMouseListener(oyenteDeRaton);
        ver_lista.addMouseListener(oyenteDeRaton);
        guardar.addMouseListener(oyenteDeRaton);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if ((ke.getSource() == txttelefono) ||(ke.getSource() == txtdia) || (ke.getSource() == txtaño)|| (ke.getSource() == txtmes)){
            char c = ke.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == txtcedula) {
            char c = ke.getKeyChar();
            System.out.println(c);
            String aux = txtcedula.getText();
            txtcedula.setText("");
            if (!aux.isEmpty()) {
                aux = aux.substring(0, aux.length() - 1);
            }
            aux += String.valueOf(c).toUpperCase();
            txtcedula.setText(aux);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == txtcedula) {
            char c = ke.getKeyChar();
            System.out.println(c);
            String aux = txtcedula.getText();
            txtcedula.setText("");
            if (!aux.isEmpty()) {
                aux = aux.substring(0, aux.length() - 1);
            }
            aux += String.valueOf(c).toUpperCase();
            txtcedula.setText(aux);
        }
    }
    
    //MÉTODO PARA EXTRAER EL ITEM SELECCIONADO CON EL MANEJO DE EVENTO DE ItemEvent
    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource()==menu){
            String seleccionado=(String)menu.getSelectedItem();
        }
    }
}
