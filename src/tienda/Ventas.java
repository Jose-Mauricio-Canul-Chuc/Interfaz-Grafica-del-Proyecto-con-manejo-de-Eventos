package tienda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventas extends JFrame implements ActionListener,KeyListener{
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    //Se declaran componentes gráficos
    JLabel titulo,folio,producto,costounitario,cantidad,atendio,telefono,fecha_venta,diag1,diag2;
    JTextField txtfolio,txtproducto,txtcostounitario,txtiva,txtcantidad,txtatendio,txttelefono,txtfecha_venta,txtdia,txtmes,txtaño;
    JButton generar_factura,cancelar;
    public Ventas(){
        setSize(550,300);//Establecemos el tamaño de la ventana
        setTitle("Ventas");//Establecemos el titulo de la ventana
        setLocationRelativeTo(null);//Establecemos que la ventana aparezca en el centro de la pantalla
        setMinimumSize(new Dimension(550,300));//Se establece el tamaño mínimo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instanciamos los controles gráficos
        titulo=new JLabel("Ventas");
        titulo.setForeground(Color.WHITE);
        folio=new JLabel("Fólio:");
        folio.setForeground(Color.WHITE);
        producto=new JLabel("Producto:");
        producto.setForeground(Color.WHITE);
        costounitario=new JLabel("Costo unitario: $");
        costounitario.setForeground(Color.WHITE);
        cantidad=new JLabel("Cantidad:");
        cantidad.setForeground(Color.WHITE);
        atendio=new JLabel("Atendió:");
        atendio.setForeground(Color.WHITE);
        telefono=new JLabel("Télefono:");
        telefono.setForeground(Color.WHITE);
        fecha_venta=new JLabel("Fecha de Venta:");
        fecha_venta.setForeground(Color.WHITE);
        diag1=new JLabel("/");
        diag1.setForeground(Color.WHITE);
        diag2=new JLabel("/");
        diag2.setForeground(Color.WHITE);
        txtfolio=new JTextField(12);
        txtproducto=new JTextField(15);
        txtcostounitario=new JTextField(4);
        txtcantidad=new JTextField(2);
        txtatendio=new JTextField(20);
        txttelefono=new JTextField(12);
        txtdia=new JTextField(2);
        txtmes=new JTextField(2);
        txtaño=new JTextField(4);
        generar_factura=new JButton("Generar Factura");
        cancelar=new JButton("Cancelar");
        eventoOyenteRaton();
        
        //LE INDICAMOS A CADA CONTROL CUAL ES EL OBJETO QUE ADMINISTRARÁ SUS EVENTOS
    	generar_factura.addActionListener(this);
        cancelar.addActionListener(this);
        txtfolio.addKeyListener(this);
        txtproducto.addKeyListener(this);
        txtcostounitario.addKeyListener(this);
        txtcantidad.addKeyListener(this);
        txtatendio.addKeyListener(this);
        txttelefono.addKeyListener(this);
        txtdia.addKeyListener(this);
        txtmes.addKeyListener(this);
        txtaño.addKeyListener(this);
        
        //PREPARACION DE LOS PANELES
        p1=new JPanel();  p2=new JPanel();  p3=new JPanel();  p4=new JPanel();  p5=new JPanel(); p6=new JPanel(); p7=new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7.setLayout(new GridLayout(5,1));
        
        //AGREGAMOS LOS CONTROLES A LOS PANELES
        p1.add(titulo);
        p1.setBackground(new Color(0, 102, 102));//Establecemos el color del panel
        p2.add(folio); p2.add(txtfolio);  p2.add(producto); p2.add(txtproducto);
        p2.setBackground(new Color(0, 102, 102));
        p3.add(costounitario); p3.add(txtcostounitario);  p3.add(cantidad); p3.add(txtcantidad);
        p3.setBackground(new Color(0, 102, 102));
        p4.add(atendio); p4.add(txtatendio);  p4.add(telefono); p4.add(txttelefono);
        p4.setBackground(new Color(0, 102, 102));
        p5.add(txtdia); p5.add(diag1); p5.add(txtmes); p5.add(diag2); p5.add(txtaño);
        p5.setBackground(new Color(0, 102, 102));
        p6.add(fecha_venta); p6.add(p5);  p6.add(generar_factura); p6.add(cancelar);
        p6.setBackground(new Color(0, 102, 102));
        
        p7.add(p1);
        p7.add(p2);
        p7.add(p3);
        p7.add(p4);
        p7.add(p6);
        p7.setBackground(new Color(0, 102, 102));
        
        //OBTENEMOS EL PANEL DE CONTENIDO DE LA VENTANA
        Container mipanel=getContentPane();
        mipanel.setLayout(new BorderLayout());
                
        //AGREGAMOS LOS PANELES AL CONTENEDOR
        mipanel.add(p7,BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelar){	
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
                if(me.getSource()== generar_factura){
                    JOptionPane.showMessageDialog(null, "Aún no se pueden generar facturas");
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
        generar_factura.addMouseListener(oyenteDeRaton);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if ((ke.getSource() == txtcostounitario) || (ke.getSource() == txtcantidad) || (ke.getSource() == txttelefono)
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
