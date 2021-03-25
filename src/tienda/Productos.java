package tienda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Productos extends JFrame implements ActionListener,KeyListener{
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    //Se declaran componentes gráficos
    JLabel titulo,codigo,nombre,proveedor,precio,fecha,diag1,diag2;
    JTextField txtcodigo,txtnombre,txtproveedor,txtprecio,txtdia,txtmes,txtaño;
    JButton buscar,lista_productos,guardar,cancelar,salir;
    
    public Productos(){
        setSize(450,340);//Establecemos el tamaño de la ventana
        setTitle("Productos");//Establecemos el titulo de la ventana
        setLocationRelativeTo(null);//Establecemos que la ventana aparezca en el centro de la pantalla
        setMinimumSize(new Dimension(450,340));//Se establece el tamaño mínimo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instanciamos los controles gráficos
        titulo=new JLabel("Administrador de Productos");
        titulo.setForeground(Color.WHITE);
        codigo=new JLabel("Código:");
        codigo.setForeground(Color.WHITE);
        nombre=new JLabel("Nombre:");
        nombre.setForeground(Color.WHITE);
        proveedor=new JLabel("Proveedor:");
        proveedor.setForeground(Color.WHITE);
        precio=new JLabel("Precio: $");
        precio.setForeground(Color.WHITE);
        fecha=new JLabel("Fecha:");
        fecha.setForeground(Color.WHITE);
        diag1=new JLabel("/");
        diag1.setForeground(Color.WHITE);
        diag2=new JLabel("/");
        diag2.setForeground(Color.WHITE);
        txtcodigo=new JTextField(12);
        txtnombre=new JTextField(25);
        txtproveedor=new JTextField(20);
        txtprecio=new JTextField(8);
        txtdia=new JTextField(2);
        txtmes=new JTextField(2);
        txtaño=new JTextField(4);
        buscar=new JButton("Buscar");
        lista_productos=new JButton("Ver Productos");
        guardar=new JButton("Guardar");
        cancelar=new JButton("Cancelar");
        salir=new JButton("Salir");
        eventoOyenteRaton();
        
        //LE INDICAMOS A CADA CONTROL CUAL ES EL OBJETO QUE ADMINISTRARÁ SUS EVENTOS
    	buscar.addActionListener(this);
        lista_productos.addActionListener(this);
        guardar.addActionListener(this);
        cancelar.addActionListener(this);
        salir.addActionListener(this);
        txtcodigo.addKeyListener(this);
        txtnombre.addKeyListener(this);
        txtproveedor.addKeyListener(this);
        txtprecio.addKeyListener(this);
        txtdia.addKeyListener(this);
        txtmes.addKeyListener(this);
        txtaño.addKeyListener(this);
        
        //PREPARACION DE LOS PANELES
        p1=new JPanel();  p2=new JPanel();  p3=new JPanel();  p4=new JPanel();  p5=new JPanel(); p6=new JPanel(); p7=new JPanel(); p8=new JPanel(); 
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setLayout(new FlowLayout());
        p8.setLayout(new GridLayout(6,1));
        
        //AGREGAMOS LOS CONTROLES A LOS PANELES
        p1.add(titulo);
        p1.setBackground(new Color(0, 102, 102));
        p2.add(codigo); p2.add(txtcodigo);  p2.add(buscar); p2.add(lista_productos);
        p2.setBackground(new Color(0, 102, 102));
        p3.add(nombre); p3.add(txtnombre);  
        p3.setBackground(new Color(0, 102, 102));
        p4.add(proveedor); p4.add(txtproveedor);
        p4.setBackground(new Color(0, 102, 102));
        p5.add(txtdia); p5.add(diag1); p5.add(txtmes); p5.add(diag2); p5.add(txtaño);
        p5.setBackground(new Color(0, 102, 102));
        p6.add(precio); p6.add(txtprecio); p6.add(fecha); p6.add(p5);
        p6.setBackground(new Color(0, 102, 102));
        p7.add(guardar); p7.add(cancelar);  p7.add(salir);
        p7.setBackground(new Color(0, 102, 102));
        
        p8.add(p1);
        p8.add(p2);
        p8.add(p3);
        p8.add(p4);
        p8.add(p6);
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
                if(me.getSource()== lista_productos){
                    JOptionPane.showMessageDialog(null, "Aún no hay productos guardados");
	        }
                if(me.getSource()== buscar){
                    JOptionPane.showMessageDialog(null, "Aún no hay productos guardados");
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
        lista_productos.addMouseListener(oyenteDeRaton);
        buscar.addMouseListener(oyenteDeRaton);
        guardar.addMouseListener(oyenteDeRaton);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if ((ke.getSource() == txtcodigo) || (ke.getSource() == txtprecio)
            || (ke.getSource() == txtdia) || (ke.getSource() == txtaño)|| (ke.getSource() == txtmes)){
            char c = ke.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
}
        