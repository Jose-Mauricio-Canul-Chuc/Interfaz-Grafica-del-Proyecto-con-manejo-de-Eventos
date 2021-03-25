package tienda;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Mauricio
 */
public class Ventana extends JFrame implements ActionListener{
    JPanel p1,p2;
    //Se declaran componentes gráficos
    JLabel nombre;
    JButton productos,clientes,ventas,empleados;
        
    public Ventana(){
        setSize(500,500);//Establecemos el tamaño de la ventana
        setTitle("Mini super La esperanza");//Establecemos el titulo de la ventana
        setLocationRelativeTo(null);//Establecemos que la ventana aparezca en el centro de la pantalla
        setMinimumSize(new Dimension(500,200));//Se establece el tamaño mínimo de la ventana
        //getContentPane().setBackground(Color.DARK_GRAY);//Se establece el color de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instanciamos los controles gráficos
        nombre=new JLabel("Mini Super");
        nombre.setForeground(Color.WHITE);//Se establece el color de la letra
        nombre.setFont(new Font("Britannic Bold",Font.BOLD,70));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Container mipanel=getContentPane();
        mipanel.setLayout(new BorderLayout());
        //menu.setIcon(new ImageIcon(getClass().getResource("/interfaz_principal/imagenes/inicio.png")));//Agregamos in icono al botón
        productos=new JButton("Productos");
        productos.setFont(new Font("arial",Font.PLAIN,20));
        clientes=new JButton("Clientes");
        clientes.setFont(new Font("arial",Font.PLAIN,20));
        ventas=new JButton("Ventas");
        ventas.setFont(new Font("arial",Font.PLAIN,20));
        empleados=new JButton("Empleados");
        empleados.setFont(new Font("arial",Font.PLAIN,20));
        
        //LE INDICAMOS A CADA CONTROL CUAL ES EL OBJETO QUE ADMINISTRARÁ SUS EVENTOS
    	productos.addActionListener(this);
        clientes.addActionListener(this);
        ventas.addActionListener(this);
        empleados.addActionListener(this);
        
        //PREPARACION DE LOS PANELES
        p1=new JPanel();  p2=new JPanel();
        p1.setLayout(new GridLayout());
        p1.setBackground(new Color(0, 102, 102));//Establecemos el color del panel
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.LIGHT_GRAY);//Establecemos el color del panel
        
        //AGREGAMOS LOS CONTROLES A LOS PANELES
        p1.add(nombre);
        p2.add(productos);
        p2.add(clientes);
        p2.add(ventas);
        p2.add(empleados);
                
        //AGREGAMOS LOS PANELES AL CONTENEDOR
        mipanel.add(p1,BorderLayout.CENTER);
        mipanel.add(p2,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //identificamos el origen del evento
        if(evento.getSource() == productos){	
            Productos abrir=new Productos();
            //abrir.setVisible(true);
            this.setVisible(false);
        }
        if(evento.getSource()== clientes){
            Clientes abrir=new Clientes();
            abrir.setVisible(true);
            this.setVisible(false);
        }
        if(evento.getSource()== ventas){
            Ventas abrir=new Ventas();
            abrir.setVisible(true);
            this.setVisible(false);
        }
        if(evento.getSource()== empleados){
            Empleados abrir=new Empleados();
            abrir.setVisible(true);
            this.setVisible(false);
        }
    }
}
