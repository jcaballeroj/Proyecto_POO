/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ahorcado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jcaba
 */
public final class AhorcadoNivel2 extends javax.swing.JFrame {

    /**
     * Creates new form AhorcadoNivel2
     */
    public JButton btns[], botonFrase;
    public String palabras[];
    public int ran;
    public int err;
    public String res[];
    
    private int puntaje = 100;
    private int intentos = 0;
    
    private JTextField[] txtFields;
    
    public AhorcadoNivel2() {
        initComponents();
        palabras = new String[5];
        btns = new JButton[27];
        botonFrase = new JButton();

        txtFields = new JTextField[8]; // 8 JTextField para cada letra de "ahorcado"
        
        //Palabras para adivinar
        palabras[0] = "llave".toUpperCase();
        palabras[1] = "caracol".toUpperCase();
        palabras[2] = "huevo".toUpperCase();
        palabras[3] = "reloj".toUpperCase();
        palabras[4] = "calle".toUpperCase();
        
        //txtField en pantalla 
        txtFields[0] = txtA;
        txtFields[1] = txtH;
        txtFields[2] = txtO;
        txtFields[3] = txtR;
        txtFields[4] = txtC;
        txtFields[5] = txtA4;
        txtFields[6] = txtD;
        txtFields[7] = txtO2;

        //Botones para las letras
        btns[1] = a_facil;
        btns[2] = b_facil;
        btns[3] = c_facil;
        btns[4] = d_facil;
        btns[5] = e_facil;
        btns[6] = f_facil;
        btns[7] = g_facil;
        btns[8] = h_facil;
        btns[9] = i_facil;
        btns[10] = j_facil;
        btns[11] = k_facil;
        btns[12] = l_facil;
        btns[13] = m_facil;
        btns[14] = n_facil;
        btns[15] = o_facil;
        btns[16] = p_facil;
        btns[17] = q_facil;
        btns[18] = r_facil;
        btns[19] = s_facil;
        btns[20] = t_facil;
        btns[21] = u_facil;
        btns[22] = v_facil;
        btns[23] = w_facil;
        btns[24] = x_facil;
        btns[25] = y_facil;
        btns[26] = z_facil;

        botonFrase = btnFrase;

        for (int i = 1; i < 27; i++) {
            btns[i].addActionListener((ActionEvent e) -> {
                checarLetra(e);
            });
        }

        //mostrando la frase que salio aleatorio para advinidar la palabra
        botonFrase.addActionListener((ActionEvent e) -> {
            // Aquí muestras la frase correspondiente a la palabra que se está adivinando
            if (palabras[ran].equals(palabras[0])) {
                JOptionPane.showMessageDialog(null, "No muerde ni ladra, pero tiene dientes y la casa guarda. ¿Qué es?");
            } else if (palabras[ran].equals(palabras[1])) {
                JOptionPane.showMessageDialog(null, "No es más grande que una nuez, sube al monte y no tiene pies.");
            } else if (palabras[ran].equals(palabras[2])) {
                JOptionPane.showMessageDialog(null, "Es blanco como la sal. Fácil de abrir, pero no lo puedes cerrar");
            }else if (palabras[ran].equals(palabras[3])) {
                JOptionPane.showMessageDialog(null, "¿Cuál es aquel pobrecito, siempre andando, siempre andando, y no sale de su sitio?");   
            }else if (palabras[ran].equals(palabras[4])) {
                JOptionPane.showMessageDialog(null, "Todos pasan por mí, yo nunca paso por nadie. Todos preguntan por mí, yo no pregunto por nadie");   
            }
        });
        iniciar();

    }

    public void iniciar() {
        lblPuntaje.setText("Puntaje= "+puntaje);
        lblIntentos.setText("Intentos= "+intentos);
        err = 0;
        jTextPane1.setText("");
        //para generar una palabra aleatoriamente
        ran = (int) 0 + (int) (Math.random() * ((palabras.length - 1) + 1));
        //SEPARA EL MENSAJE POR PALABRAS
        String pal[] = palabras[ran].split(" ");
        res = new String[palabras[ran].length() + 1];
        int j = 0;

        //Activa los botones cuando inicia el juego
        for (int i = 1; i < 27; i++) {
            btns[i].setEnabled(true);
        }

       if (palabras[ran].equals(palabras[0])) {
                JOptionPane.showMessageDialog(null, "No muerde ni ladra, pero tiene dientes y la casa guarda. ¿Qué es?");
            } else if (palabras[ran].equals(palabras[1])) {
                JOptionPane.showMessageDialog(null, "No es más grande que una nuez, sube al monte y no tiene pies.");
            } else if (palabras[ran].equals(palabras[2])) {
                JOptionPane.showMessageDialog(null, "Es blanco como la sal. Fácil de abrir, pero no lo puedes cerrar");
            }else if (palabras[ran].equals(palabras[3])) {
                JOptionPane.showMessageDialog(null, "¿Cuál es aquel pobrecito, siempre andando, siempre andando, y no sale de su sitio?");
                
            }

        // seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                jTextPane1.setText(jTextPane1.getText() + "_ ");
                res[j++] = "_";
            }
            jTextPane1.setText(jTextPane1.getText());
            res[j++] = " ";
        }
        
        // Reiniciar los JTextField
        for (JTextField txtField : txtFields) {
            txtField.setText("");
        }

    }
    int porcentaje, porcentajePromedio, porcentajeTotal ;
    int contador = 0;

    public void checarLetra(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        char c[];
        intentos++;
        lblIntentos.setText("Intentos= "+intentos);
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 27; i++) {
            if (bt == btns[i]) {
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < palabras[ran].length(); j++) {
                    if (c[0] == palabras[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                    jTextPane1.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            jTextPane1.setText(jTextPane1.getText());
                        } else {
                            jTextPane1.setText(jTextPane1.getText() + re + " ");
                        }
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    if (gano) {
                        JOptionPane.showMessageDialog(this, "Ganaste :3!!!");
                        contador++;
                         porcentajePromedio += porcentaje;
                        if (contador == 3) {
                            porcentajeTotal = porcentajePromedio/contador;
                            grafica();
                            int respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (respuesta == JOptionPane.YES_OPTION) {
                                //Llamando al tercer nivel
                                AhorcadoNivel3 jNivel3 = new AhorcadoNivel3();
                                jNivel3.setVisible(true);
                                dispose();
                                break;
                            } else {
                                menuAhorcado menu = new menuAhorcado();
                                menu.setVisible(true);
                                dispose();
                                break;
                            }
                        }
                        iniciar();
                        return;
                    }

                    //Si la letra no esta se aumenta el mensaje y se le disminuye al puntaje
                } else {
                    err++;
                    puntaje-=4;
                    lblPuntaje.setText("Puntaje= "+puntaje);
                   
                    //Porcentaje de error
                    porcentaje = (err *100)/8;
                    
                    String palabraError = "AHORCADO";
                    if (err <= palabraError.length()) {
                        txtFields[err - 1].setText(String.valueOf(palabraError.charAt(err - 1)));
                    }
                    //Si llega a 8 intentos y el porcentaje de error es 100% se inicia de nuevo
                    if (err == 8 && porcentaje == 100) {
                        JOptionPane.showMessageDialog(this, "Intenta con otra palabra. La respuesta es: \n" + palabras[ran]);
                        iniciar();
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }
    }
    
    public void grafica() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        datos.setValue(puntaje, "Puntaje: " +puntaje, "");
        datos.setValue(intentos, "Intentos: " + intentos, "");
        datos.setValue(porcentaje, "Porcentaje Promedio total: " +porcentajeTotal+" %", "");
        
        JFreeChart grafico_barras = ChartFactory.createBarChart3D("Calificacion Del Segundo Nivel", "", "", datos);

        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400, 300));
        // Mostrar el gráfico en un JOptionPane
        JOptionPane.showMessageDialog(null, panel, "Gráfico de Calificación", JOptionPane.PLAIN_MESSAGE);
        
        pack();
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_ahorcado = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        z_facil = new javax.swing.JButton();
        y_facil = new javax.swing.JButton();
        x_facil = new javax.swing.JButton();
        w_facil = new javax.swing.JButton();
        v_facil = new javax.swing.JButton();
        t_facil = new javax.swing.JButton();
        u_facil = new javax.swing.JButton();
        k_facil = new javax.swing.JButton();
        a_facil = new javax.swing.JButton();
        b_facil = new javax.swing.JButton();
        l_facil = new javax.swing.JButton();
        c_facil = new javax.swing.JButton();
        m_facil = new javax.swing.JButton();
        d_facil = new javax.swing.JButton();
        n_facil = new javax.swing.JButton();
        e_facil = new javax.swing.JButton();
        o_facil = new javax.swing.JButton();
        f_facil = new javax.swing.JButton();
        p_facil = new javax.swing.JButton();
        q_facil = new javax.swing.JButton();
        h_facil = new javax.swing.JButton();
        i_facil = new javax.swing.JButton();
        r_facil = new javax.swing.JButton();
        j_facil = new javax.swing.JButton();
        s_facil = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        g_facil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnFrase = new javax.swing.JButton();
        lblPuntaje = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtA = new javax.swing.JTextField();
        txtH = new javax.swing.JTextField();
        txtO = new javax.swing.JTextField();
        txtR = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        txtD = new javax.swing.JTextField();
        txtA4 = new javax.swing.JTextField();
        txtO2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background_ahorcado.setBackground(new java.awt.Color(255, 255, 255));
        background_ahorcado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(141, 153, 175), 15));
        background_ahorcado.setPreferredSize(new java.awt.Dimension(806, 462));

        jPanel3.setBackground(new java.awt.Color(120, 133, 163));
        jPanel3.setPreferredSize(new java.awt.Dimension(347, 270));

        jLabel7.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("°");

        jLabel8.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("°");

        jLabel9.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("°");

        jLabel10.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("°");

        jLabel11.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("°");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel5.setBackground(new java.awt.Color(204, 207, 217));

        jLabel14.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel14.setText("adivina la palabra");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(120, 133, 163));

        jLabel2.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("°");

        jLabel3.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("°");

        jLabel4.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("°");

        jLabel5.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("°");

        jLabel6.setFont(new java.awt.Font("Avocado Cake", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("°");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        z_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        z_facil.setText("Z");
        z_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                z_facilActionPerformed(evt);
            }
        });

        y_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        y_facil.setText("Y");
        y_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y_facilActionPerformed(evt);
            }
        });

        x_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        x_facil.setText("X");
        x_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_facilActionPerformed(evt);
            }
        });

        w_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        w_facil.setText("W");
        w_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_facilActionPerformed(evt);
            }
        });

        v_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        v_facil.setText("V");
        v_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_facilActionPerformed(evt);
            }
        });

        t_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        t_facil.setText("T");
        t_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_facilActionPerformed(evt);
            }
        });

        u_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        u_facil.setText("U");
        u_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_facilActionPerformed(evt);
            }
        });

        k_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        k_facil.setText("K");
        k_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                k_facilActionPerformed(evt);
            }
        });

        a_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        a_facil.setText("A");
        a_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_facilActionPerformed(evt);
            }
        });

        b_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        b_facil.setText("B");
        b_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_facilActionPerformed(evt);
            }
        });

        l_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        l_facil.setText("L");
        l_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_facilActionPerformed(evt);
            }
        });

        c_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        c_facil.setText("C");
        c_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_facilActionPerformed(evt);
            }
        });

        m_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        m_facil.setText("M");
        m_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_facilActionPerformed(evt);
            }
        });

        d_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        d_facil.setText("D");
        d_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_facilActionPerformed(evt);
            }
        });

        n_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        n_facil.setText("N");
        n_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_facilActionPerformed(evt);
            }
        });

        e_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        e_facil.setText("E");
        e_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_facilActionPerformed(evt);
            }
        });

        o_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        o_facil.setText("O");
        o_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_facilActionPerformed(evt);
            }
        });

        f_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        f_facil.setText("F");
        f_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_facilActionPerformed(evt);
            }
        });

        p_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        p_facil.setText("P");
        p_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_facilActionPerformed(evt);
            }
        });

        q_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        q_facil.setText("Q");
        q_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q_facilActionPerformed(evt);
            }
        });

        h_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        h_facil.setText("H");
        h_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h_facilActionPerformed(evt);
            }
        });

        i_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        i_facil.setText("I");
        i_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_facilActionPerformed(evt);
            }
        });

        r_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        r_facil.setText("R");
        r_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_facilActionPerformed(evt);
            }
        });

        j_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        j_facil.setText("J");
        j_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_facilActionPerformed(evt);
            }
        });

        s_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        s_facil.setText("S");
        s_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_facilActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(146, 154, 171));

        jLabel17.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel17.setText("n");

        jLabel18.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel18.setText("I");

        jLabel19.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel19.setText("V");

        jLabel20.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel20.setText("E");

        jLabel22.setFont(new java.awt.Font("Avocado Cake", 0, 24)); // NOI18N
        jLabel22.setText("L");

        jLabel21.setFont(new java.awt.Font("Dinomiko", 0, 36)); // NOI18N
        jLabel21.setText("2");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel17))
                                .addGap(13, 13, 13))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(13, 13, 13))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(jLabel18)
                .addGap(10, 10, 10)
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addGap(8, 8, 8)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        g_facil.setFont(new java.awt.Font("Avocado Cake", 0, 18)); // NOI18N
        g_facil.setText("G");
        g_facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_facilActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        btnFrase.setBackground(new java.awt.Color(204, 204, 255));
        btnFrase.setText("?");

        lblPuntaje.setText("...");

        lblIntentos.setText("...");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtA.setEditable(false);
        txtA.setBackground(new java.awt.Color(204, 204, 204));
        txtA.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        txtA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtA.setAutoscrolls(false);
        txtA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtA.setFocusable(false);
        txtA.setMaximumSize(new java.awt.Dimension(50, 88));
        txtA.setMinimumSize(new java.awt.Dimension(50, 88));
        txtA.setOpaque(true);
        txtA.setPreferredSize(new java.awt.Dimension(50, 88));
        txtA.setRequestFocusEnabled(false);

        txtH.setEditable(false);
        txtH.setBackground(new java.awt.Color(204, 204, 204));
        txtH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtH.setAutoscrolls(false);
        txtH.setBorder(null);
        txtH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtH.setMaximumSize(new java.awt.Dimension(50, 88));
        txtH.setMinimumSize(new java.awt.Dimension(50, 88));
        txtH.setPreferredSize(new java.awt.Dimension(50, 88));
        txtH.setRequestFocusEnabled(false);
        txtH.setVerifyInputWhenFocusTarget(false);

        txtO.setEditable(false);
        txtO.setBackground(new java.awt.Color(204, 204, 204));
        txtO.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtO.setMaximumSize(new java.awt.Dimension(50, 88));
        txtO.setMinimumSize(new java.awt.Dimension(50, 88));
        txtO.setPreferredSize(new java.awt.Dimension(50, 88));
        txtO.setRequestFocusEnabled(false);

        txtR.setEditable(false);
        txtR.setBackground(new java.awt.Color(204, 204, 204));
        txtR.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtR.setMaximumSize(new java.awt.Dimension(50, 88));
        txtR.setMinimumSize(new java.awt.Dimension(50, 88));
        txtR.setPreferredSize(new java.awt.Dimension(50, 88));
        txtR.setRequestFocusEnabled(false);

        txtC.setEditable(false);
        txtC.setBackground(new java.awt.Color(204, 204, 204));
        txtC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtC.setMaximumSize(new java.awt.Dimension(50, 88));
        txtC.setMinimumSize(new java.awt.Dimension(50, 88));
        txtC.setPreferredSize(new java.awt.Dimension(50, 88));
        txtC.setRequestFocusEnabled(false);

        txtD.setEditable(false);
        txtD.setBackground(new java.awt.Color(204, 204, 204));
        txtD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtD.setMaximumSize(new java.awt.Dimension(50, 88));
        txtD.setMinimumSize(new java.awt.Dimension(50, 88));
        txtD.setPreferredSize(new java.awt.Dimension(50, 88));
        txtD.setRequestFocusEnabled(false);

        txtA4.setEditable(false);
        txtA4.setBackground(new java.awt.Color(204, 204, 204));
        txtA4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtA4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtA4.setMaximumSize(new java.awt.Dimension(50, 88));
        txtA4.setMinimumSize(new java.awt.Dimension(50, 88));
        txtA4.setName(""); // NOI18N
        txtA4.setPreferredSize(new java.awt.Dimension(50, 88));
        txtA4.setRequestFocusEnabled(false);
        txtA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA4ActionPerformed(evt);
            }
        });

        txtO2.setEditable(false);
        txtO2.setBackground(new java.awt.Color(204, 204, 204));
        txtO2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtO2.setMaximumSize(new java.awt.Dimension(50, 88));
        txtO2.setMinimumSize(new java.awt.Dimension(50, 88));
        txtO2.setPreferredSize(new java.awt.Dimension(50, 88));
        txtO2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout background_ahorcadoLayout = new javax.swing.GroupLayout(background_ahorcado);
        background_ahorcado.setLayout(background_ahorcadoLayout);
        background_ahorcadoLayout.setHorizontalGroup(
            background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_ahorcadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(a_facil)
                                            .addComponent(k_facil))
                                        .addGap(11, 11, 11)
                                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                                .addComponent(t_facil)
                                                .addGap(21, 21, 21)
                                                .addComponent(u_facil)
                                                .addGap(21, 21, 21)
                                                .addComponent(v_facil)
                                                .addGap(11, 11, 11)
                                                .addComponent(w_facil)
                                                .addGap(21, 21, 21)
                                                .addComponent(x_facil)
                                                .addGap(21, 21, 21)
                                                .addComponent(y_facil)
                                                .addGap(11, 11, 11)
                                                .addComponent(z_facil))
                                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                                        .addComponent(l_facil)
                                                        .addGap(11, 11, 11)
                                                        .addComponent(m_facil)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(n_facil)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(o_facil)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(p_facil)
                                                        .addGap(11, 11, 11)
                                                        .addComponent(q_facil)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(r_facil)
                                                        .addGap(21, 21, 21)
                                                        .addComponent(s_facil))
                                                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_ahorcadoLayout.createSequentialGroup()
                                                                .addComponent(b_facil)
                                                                .addGap(11, 11, 11)
                                                                .addComponent(c_facil)
                                                                .addGap(21, 21, 21)
                                                                .addComponent(d_facil)
                                                                .addGap(21, 21, 21)
                                                                .addComponent(e_facil)
                                                                .addGap(21, 21, 21)
                                                                .addComponent(f_facil)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(g_facil)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(h_facil)))
                                                        .addGap(12, 12, 12)
                                                        .addComponent(i_facil)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(j_facil))))))
                                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17))
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFrase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)))
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_ahorcadoLayout.createSequentialGroup()
                                .addComponent(lblIntentos)
                                .addGap(44, 44, 44))))
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPuntaje)
                        .addGap(33, 33, 33))))
        );
        background_ahorcadoLayout.setVerticalGroup(
            background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addComponent(lblPuntaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIntentos))
                            .addComponent(btnVolver))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_ahorcadoLayout.createSequentialGroup()
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtH, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtO, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtA4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtO2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(background_ahorcadoLayout.createSequentialGroup()
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnFrase)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addComponent(a_facil)
                                .addGap(11, 11, 11)
                                .addComponent(k_facil))
                            .addGroup(background_ahorcadoLayout.createSequentialGroup()
                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_facil)
                                    .addComponent(c_facil)
                                    .addComponent(d_facil)
                                    .addComponent(e_facil)
                                    .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(f_facil)
                                        .addComponent(i_facil)
                                        .addComponent(j_facil)
                                        .addComponent(h_facil)
                                        .addComponent(g_facil)))
                                .addGap(11, 11, 11)
                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_facil)
                                    .addComponent(m_facil)
                                    .addComponent(n_facil)
                                    .addComponent(o_facil)
                                    .addComponent(p_facil)
                                    .addComponent(q_facil)
                                    .addComponent(r_facil)
                                    .addComponent(s_facil))
                                .addGap(21, 21, 21)
                                .addGroup(background_ahorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_facil)
                                    .addComponent(u_facil)
                                    .addComponent(v_facil)
                                    .addComponent(w_facil)
                                    .addComponent(x_facil)
                                    .addComponent(y_facil)
                                    .addComponent(z_facil))))
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_ahorcado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_ahorcado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void z_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_z_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_z_facilActionPerformed

    private void y_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y_facilActionPerformed

    private void x_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x_facilActionPerformed

    private void w_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w_facilActionPerformed

    private void v_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v_facilActionPerformed

    private void t_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_facilActionPerformed

    private void u_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_facilActionPerformed

    private void k_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_k_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_k_facilActionPerformed

    private void a_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a_facilActionPerformed

    private void b_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_facilActionPerformed

    private void l_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_facilActionPerformed

    private void c_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_facilActionPerformed

    private void m_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_facilActionPerformed

    private void d_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_facilActionPerformed

    private void n_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_facilActionPerformed

    private void e_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_facilActionPerformed

    private void o_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_o_facilActionPerformed

    private void f_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_facilActionPerformed

    private void p_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_facilActionPerformed

    private void q_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q_facilActionPerformed

    private void h_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h_facilActionPerformed

    private void i_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_i_facilActionPerformed

    private void r_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_facilActionPerformed

    private void j_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_facilActionPerformed

    private void s_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_facilActionPerformed

    private void g_facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_facilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_facilActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        menuAhorcado jMenu = new menuAhorcado();
        jMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AhorcadoNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AhorcadoNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AhorcadoNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AhorcadoNivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AhorcadoNivel2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a_facil;
    private javax.swing.JButton b_facil;
    private javax.swing.JPanel background_ahorcado;
    private javax.swing.JButton btnFrase;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton c_facil;
    private javax.swing.JButton d_facil;
    private javax.swing.JButton e_facil;
    private javax.swing.JButton f_facil;
    private javax.swing.JButton g_facil;
    private javax.swing.JButton h_facil;
    private javax.swing.JButton i_facil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton j_facil;
    private javax.swing.JButton k_facil;
    private javax.swing.JButton l_facil;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JButton m_facil;
    private javax.swing.JButton n_facil;
    private javax.swing.JButton o_facil;
    private javax.swing.JButton p_facil;
    private javax.swing.JButton q_facil;
    private javax.swing.JButton r_facil;
    private javax.swing.JButton s_facil;
    private javax.swing.JButton t_facil;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtA4;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtH;
    private javax.swing.JTextField txtO;
    private javax.swing.JTextField txtO2;
    private javax.swing.JTextField txtR;
    private javax.swing.JButton u_facil;
    private javax.swing.JButton v_facil;
    private javax.swing.JButton w_facil;
    private javax.swing.JButton x_facil;
    private javax.swing.JButton y_facil;
    private javax.swing.JButton z_facil;
    // End of variables declaration//GEN-END:variables
}
