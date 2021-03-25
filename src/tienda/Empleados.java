package tienda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Empleados extends JFrame implements ActionListener,KeyListener{
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
    //Se declaran componentes gráficos
    JLabel titulo,cedula,nombre,apellido,direccion,email,telefono,puesto,fecha_ingreso,diag1,diag2,genero;
    JTextField txtcedula,txtnombre,txtapellido,txtdireccion,txtemail,txttelefono,txtpuesto,txtdia,txtmes,txtaño;
    JButton buscar,lista_empleados,cancelar,salir,guardar;
    JRadioButton RadioBoton1,RadioBoton2;
    
    public Empleados(){
        setSize(520,380);//Establecemos el tamaño de la ventana
        setTitle("Administrador de Empleados");//Establecemos el titulo de la ventana
        setLocationRelativeTo(null);//Establecemos que la ventana aparezca en el centro de la pantalla
        setMinimumSize(new Dimension(520,380));//Se establece el tamaño mínimo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instanciamos los controles gráficos
        titulo=new JLabel("Administrador de Empleados");
        titulo.setForeground(Color.WHITE);
        cedula=new JLabel("Cedula:");
        cedula.setForeground(Color.WHITE);
        nombre=new JLabel("Nombre:");
        nombre.setForeground(Color.WHITE);
        apellido=new JLabel("Apellido:");
        apellido.setForeground(Color.WHITE);
        direccion=new JLabel("Dirección:");
        direccion.setForeground(Color.WHITE);
        email=new JLabel("Email:");
        email.setForeground(Color.WHITE);
        puesto=new JLabel("Puesto:");
        puesto.setForeground(Color.WHITE);
        fecha_ingreso=new JLabel("Fecha de Ingreso:");
        fecha_ingreso.setForeground(Color.WHITE);
        diag1=new JLabel("/"); 
        diag1.setForeground(Color.WHITE);
        diag2=new JLabel("/");
        diag2.setForeground(Color.WHITE);
        genero=new JLabel("Seleccione el Género:");
        genero.setForeground(Color.WHITE);
        txtcedula=new JTextField(12);
        txtnombre=new JTextField(15);
        txtapellido=new JTextField(15);
        txtdireccion=new JTextField(30);
        txtemail=new JTextField(15);
        txtpuesto=new JTextField(12);
        txtdia=new JTextField(2);
        txtmes=new JTextField(2);
        txtaño=new JTextField(4);
        buscar=new JButton("Buscar");
        lista_empleados=new JButton("Lista de Empleados");
        cancelar=new JButton("Cancelar");
        salir=new JButton("Salir");
        guardar=new JButton("Guardar");
        eventoOyenteRaton();
        RadioBoton1=new JRadioButton("Masculino",false);
        RadioBoton2=new JRadioButton("Femenino",false);
        
        //LOS RADIOBOTONES DE AÑADEN A UN GRUPO
        ButtonGroup GrupoRadioBotones=new ButtonGroup();
        GrupoRadioBotones.add(RadioBoton1);
        GrupoRadioBotones.add(RadioBoton2);
        
        
        //LE INDICAMOS A CADA CONTROL CUAL ES EL OBJETO QUE ADMINISTRARÁ SUS EVENTOS
    	buscar.addActionListener(this);
        lista_empleados.addActionListener(this);
        cancelar.addActionListener(this);
        salir.addActionListener(this);
        guardar.addActionListener(this);
        txtcedula.addKeyListener(this);
        txtnombre.addKeyListener(this);
        txtapellido.addKeyListener(this);
        txtdireccion.addKeyListener(this);
        txtemail.addKeyListener(this);
        txtpuesto.addKeyListener(this);
        txtdia.addKeyListener(this);
        txtmes.addKeyListener(this);
        txtaño.addKeyListener(this);
        
        //PREPARACION DE LOS PANELES
        p1=new JPanel();  p2=new JPanel();  p3=new JPanel();  p4=new JPanel();  p5=new JPanel(); p6=new JPanel(); p7=new JPanel(); p8=new JPanel();
        p9=new JPanel(); p10=new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setLayout(new FlowLayout(FlowLayout.LEFT));
        p8.setLayout(new FlowLayout(FlowLayout.LEFT));
        p9.setLayout(new GridLayout(7,1));
        
        //AGREGAMOS LOS CONTROLES A LOS PANELES
        p1.add(titulo);
        p1.setBackground(new Color(0, 102, 102));//Establecemos el color del panel
        p2.add(cedula); p2.add(txtcedula);  p2.add(buscar); p2.add(lista_empleados);
        p2.setBackground(new Color(0, 102, 102));
        p3.add(nombre); p3.add(txtnombre);  p3.add(apellido); p3.add(txtapellido);
        p3.setBackground(new Color(0, 102, 102));
        p4.add(direccion); p4.add(txtdireccion);
        p4.setBackground(new Color(0, 102, 102));
        p5.add(genero); p5.add(RadioBoton1); p5.add(RadioBoton2);
        p5.setBackground(new Color(0, 102, 102));
        p6.add(email); p6.add(txtemail); p6.add(puesto); p6.add(txtpuesto);
        p6.setBackground(new Color(0, 102, 102));
        p7.add(txtdia); p7.add(diag1); p7.add(txtmes); p7.add(diag2); p7.add(txtaño);
        p7.setBackground(new Color(0, 102, 102));
        p8.add(fecha_ingreso); p8.add(p7);  p8.add(cancelar); p8.add(salir); p8.add(guardar);
        p8.setBackground(new Color(0, 102, 102));
        
        p9.add(p1);
        p9.add(p2);
        p9.add(p3);
        p9.add(p4);
        p9.add(p5);
        p9.add(p6);
        p9.add(p8);
        p9.setBackground(new Color(0, 102, 102));
        
        //OBTENEMOS EL PANEL DE CONTENIDO DE LA VENTANA
        Container mipanel=getContentPane();
        mipanel.setLayout(new BorderLayout());
                
        //AGREGAMOS LOS PANELES AL CONTENEDOR
        mipanel.add(p9,BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == cancelar){	
            Ventana abrir=new Ventana();
            abrir.setVisible(true);
            this.setVisible(false);
	}
        if(ae.getSource() == salir){	
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
                    JOptionPane.showMessageDialog(null, "Aún no hay empleados registrados");
	        }
                if(me.getSource()== lista_empleados){
                    JOptionPane.showMessageDialog(null, "Aún no hay empleados registrados");
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
        lista_empleados.addMouseListener(oyenteDeRaton);
        guardar.addMouseListener(oyenteDeRaton);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if ((ke.getSource() == txtdia) || (ke.getSource() == txtaño)|| (ke.getSource() == txtmes)){
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
}
