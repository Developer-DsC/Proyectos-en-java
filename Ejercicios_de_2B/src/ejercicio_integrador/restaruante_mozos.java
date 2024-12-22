package ejercicio_integrador;

import javax.swing.JOptionPane;

/**
 *
 * @author Dalton
 */
public class restaruante_mozos extends javax.swing.JFrame {

    int n, cantpg, cantpl, cantply = 0;
    int i=1;
    double impog, impol, impoly,amayor,amesa=0;

    public restaruante_mozos() {
        initComponents();
        
        //n es el ciclo de empleados que se quiere ingresar
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de personas que desea registrar"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_empleados = new javax.swing.JComboBox<>();
        cmb_mesa = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_importe = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_calcular = new javax.swing.JButton();
        btn_ingresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel1.setText("Registro mozos restaruante \"El manaba\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setText("Empleado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel4.setText("Mesa:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel3.setText("Importe:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        cmb_empleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Gabriel Abreu", "Leonel Espinoza", "Leyton Guanoluchi" }));
        getContentPane().add(cmb_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 120, -1));

        cmb_mesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Mesa 1", "Mesa 2", "Mesa 3" }));
        getContentPane().add(cmb_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 120, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel6.setText("Cantidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 120, -1));
        getContentPane().add(txt_importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, -1));

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });
        getContentPane().add(btn_calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        jLabel7.setText(".");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 10, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
      habilitar(true);
      Limpiar();
    }//GEN-LAST:event_btn_nuevoActionPerformed
    
    //habilitar o desactivar botones y cajas de texto
    public void habilitar(boolean bol) {
        txt_cantidad.setEditable(bol);
        txt_importe.setEditable(bol);
        cmb_empleados.setEnabled(bol);
        cmb_mesa.setEnabled(bol);
    }

    
    public void ingresar_datos() {
        
            String mozo = cmb_empleados.getSelectedItem().toString();
            int mesa = Integer.parseInt(cmb_mesa.getSelectedItem().toString());
            double imp = Double.parseDouble(txt_importe.getText());
            int can = Integer.parseInt(txt_cantidad.getText());

            if (mozo.equals("Gabriel Abreu")) {
                cantpg = cantpg + can;
                impog=impog+imp;
            }

            if (mozo.equals("Leonel Espinoza")) {
                cantpl = cantpl + can;
                impol=impol+imp;
            }

            if (mozo.equals("Leyton Guanoluchi")) {
                cantply = cantply + can;
                impoly=impoly+imp;
            }
            if (amayor>imp)
            {
                amayor=imp;
                amesa=mesa;
                
            }
        }
    

    public void Limpiar() {
        txt_cantidad.setText("");
        txt_importe.setText("");
        cmb_empleados.setSelectedItem(0);
        cmb_mesa.setSelectedItem(0);

    }
    
    public void imprimir() {
        JOptionPane.showMessageDialog(null, "La cantidad de personas antendidas por cada mozo es: \nGabriel Abreu: "+cantpg+"\nReacudado: "+impog+
                                                        "\nLeonel Espinoza: "+cantpl+"\nReacudado: "+impol+
                                                        "\nLeyton Guanoluchi: "+cantply+"\nReacudado: "+impoly);
        JOptionPane.showMessageDialog(null,"La mesa de mayor recaudación fue: "+amesa+"\nRecaudó: "+amayor);
    }

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        imprimir();
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        if (!txt_cantidad.getText().equals("") && !txt_importe.getText().equals("") &&(cmb_empleados.getSelectedItem().equals(" " ))) {
            if (i <= n) {
                ingresar_datos();
                jLabel7.setText(i + "/" + n);
                if (i == n) {
                    habilitar(false);
                }

                i++;
            } else {
                JOptionPane.showMessageDialog(null, "Plazas ocupadas, por favor presione el botón calcular");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Digite un nombre y una edad porfavor.");
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

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
            java.util.logging.Logger.getLogger(restaruante_mozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(restaruante_mozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(restaruante_mozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(restaruante_mozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new restaruante_mozos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cmb_empleados;
    private javax.swing.JComboBox<String> cmb_mesa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_importe;
    // End of variables declaration//GEN-END:variables
}
