/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AccesoDatos;
import Modelo.Peliculas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private AccesoDatos a = new AccesoDatos();
    private ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
    private Peliculas p;
    private String cod, nom, gen, cla, fil;
    private int fec;

    public Principal() {
        initComponents();
        actualizarGrilla();
        this.setLocationRelativeTo(null);
    }

    public void actualizarGrilla() {
        DefaultTableModel modelo = (DefaultTableModel) grilla.getModel();
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
        if (cbofiltros.getSelectedItem() == "Sin filtro") {
            lispel = a.listarPelicula();
        } else {
            if (cbofiltros.getSelectedItem() == "Accion") {
                lispel = a.filtraracc();
            } else {
                if (cbofiltros.getSelectedItem() == "Aventura") {
                    lispel = a.filtrarave();
                } else {
                    if (cbofiltros.getSelectedItem() == "Animacion") {
                        lispel = a.filtrarani();
                    } else {
                        if (cbofiltros.getSelectedItem() == "Comedia") {
                            lispel = a.filtrarcom();
                        } else {
                            if (cbofiltros.getSelectedItem() == "Documental") {
                                lispel = a.filtrardoc();
                            } else {
                                if (cbofiltros.getSelectedItem() == "Drama") {
                                    lispel = a.filtrardram();
                                } else {
                                    if (cbofiltros.getSelectedItem() == "Romance") {
                                        lispel = a.filtrarrom();
                                    } else {
                                        if (cbofiltros.getSelectedItem() == "Sci-fy") {
                                            lispel = a.filtrarsci();
                                        } else {
                                            if (cbofiltros.getSelectedItem() == "Terror") {
                                                lispel = a.filtrarter();
                                            } else {
                                                if (cbofiltros.getSelectedItem() == "Todo espectador") {
                                                    lispel = a.filtrartod();
                                                } else {
                                                    if (cbofiltros.getSelectedItem() == "R+15") {
                                                        lispel = a.filtrarado();
                                                    } else {
                                                        lispel = a.filtraradu();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Object datos[] = new Object[5];
        int totl = 0;//para las listadas segun el filtro
        float prom = 0;// para el promedio
        for (int i = 0; i < lispel.size(); i++) {
            p = lispel.get(i);
            datos[0] = p.getCodigo();
            datos[1] = p.getNombre();
            datos[2] = p.getGenero();
            datos[3] = p.getClasificacion();
            datos[4] = p.getFecha();
            modelo.addRow(datos);
            totl++;
            prom = totl / lispel.size();//promedio de peliculas listadas en relacion al total de registros
        }
        grilla.setModel(modelo);
        lablis.setText(Integer.toString(totl));
        labtotr.setText(Integer.toString(lispel.size()));
        labpro.setText(Float.toString(prom));
    }

    public void validar() {
        cod = txtcod.getText();
        p = a.consultarPelicula(cod);
        if (p != null) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Pelicula encontrada");
            txtnom.setText(p.getNombre());
            cbogen.setSelectedItem(p.getGenero());
            if (p.getClasificacion().equalsIgnoreCase("Todo publico")) {
                rbntod.setSelected(true);
            } else {
                if (p.getClasificacion().equalsIgnoreCase("R+15")) {
                    rbn15.setSelected(true);
                } else {
                    rbn18.setSelected(true);
                }
            }
            txtfec.setText(String.valueOf(p.getFecha()));
            txtcod.setEnabled(true);
            txtnom.setEnabled(true);
            cbogen.setEnabled(true);
            rbntod.setEnabled(true);
            rbn15.setEnabled(true);
            rbn18.setEnabled(true);
            txtfec.setEnabled(true);
            btneli.setEnabled(true);
            btnmod.setEnabled(true);
            btnreg.setEnabled(false);
        } else {
            javax.swing.JOptionPane.showMessageDialog(form_registro, "pelicula no encontrada, registro habilitado");
            txtnom.setText("");
            txtnom.setEnabled(true);
            cbogen.setSelectedIndex(0);
            cbogen.setEnabled(true);
            rbntod.setSelected(false);
            rbntod.setEnabled(true);
            rbn15.setSelected(false);
            rbn15.setEnabled(true);
            rbn18.setSelected(false);
            rbn18.setEnabled(true);
            txtfec.setText("");
            txtfec.setEnabled(true);
            btneli.setEnabled(false);
            btnmod.setEnabled(false);
            btnreg.setEnabled(true);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_registro = new javax.swing.JFrame();
        btnbus = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbogen = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbntod = new javax.swing.JRadioButton();
        rbn15 = new javax.swing.JRadioButton();
        rbn18 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtfec = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        btnmod = new javax.swing.JButton();
        btneli = new javax.swing.JButton();
        labest = new javax.swing.JLabel();
        form_listado = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        grilla = new javax.swing.JTable();
        cbofiltros = new javax.swing.JComboBox<>();
        bntfiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labtotr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lablis = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labpro = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        item_registro = new javax.swing.JMenuItem();
        item_listado = new javax.swing.JMenuItem();
        item_salir = new javax.swing.JMenuItem();

        form_registro.setTitle("Formulario de Peliculas");

        btnbus.setText("Buscar");
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });

        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });

        jLabel2.setText("Codigo");

        jLabel3.setText("Max 6 caracteres");

        jLabel4.setText("Nombre");

        txtnom.setEnabled(false);
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });

        jLabel5.setText("Max 35 caracteres");

        cbogen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione genero", "Accion", "Aventura", "Animacion", "Comedia", "Documental", "Drama", "Romance", "Sci-fy", "Terror" }));
        cbogen.setEnabled(false);

        jLabel6.setText("Genero");

        jLabel7.setText("Clasificacion");

        buttonGroup1.add(rbntod);
        rbntod.setText("Todo espectador");
        rbntod.setEnabled(false);

        buttonGroup1.add(rbn15);
        rbn15.setText("R+15");
        rbn15.setEnabled(false);

        buttonGroup1.add(rbn18);
        rbn18.setText("R+18");
        rbn18.setEnabled(false);

        jLabel8.setText("Año de estreno");

        txtfec.setEnabled(false);
        txtfec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfecKeyTyped(evt);
            }
        });

        btnreg.setText("Almacenar Datos");
        btnreg.setEnabled(false);
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });

        btnmod.setText("Modificar Datos");
        btnmod.setEnabled(false);
        btnmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodActionPerformed(evt);
            }
        });

        btneli.setText("Eliminar Datos");
        btneli.setEnabled(false);
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });

        labest.setText("...");

        javax.swing.GroupLayout form_registroLayout = new javax.swing.GroupLayout(form_registro.getContentPane());
        form_registro.getContentPane().setLayout(form_registroLayout);
        form_registroLayout.setHorizontalGroup(
            form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(form_registroLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(form_registroLayout.createSequentialGroup()
                        .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(form_registroLayout.createSequentialGroup()
                                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbus)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(form_registroLayout.createSequentialGroup()
                                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbogen, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtnom, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(form_registroLayout.createSequentialGroup()
                        .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(form_registroLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbntod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbn15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbn18))
                            .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnmod, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, form_registroLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labest)
                                    .addComponent(btneli, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 89, Short.MAX_VALUE))))
            .addGroup(form_registroLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        form_registroLayout.setVerticalGroup(
            form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_registroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbus)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbogen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbntod)
                    .addComponent(rbn15)
                    .addComponent(rbn18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(form_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        form_listado.setTitle("Listado de Peliculas");
        form_listado.setResizable(false);

        grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Clacificacion", "Fecha de Estreno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grilla);
        if (grilla.getColumnModel().getColumnCount() > 0) {
            grilla.getColumnModel().getColumn(0).setResizable(false);
            grilla.getColumnModel().getColumn(1).setResizable(false);
            grilla.getColumnModel().getColumn(2).setResizable(false);
            grilla.getColumnModel().getColumn(3).setResizable(false);
            grilla.getColumnModel().getColumn(4).setResizable(false);
        }

        cbofiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin filtro", "Accion", "Aventura", "Animacion", "Comedia", "Documental", "Drama", "Romance", "Sci-fy", "Terror", "Todo espectador", "R+15", "R+18" }));

        bntfiltrar.setText("Filtrar");
        bntfiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntfiltrarMouseClicked(evt);
            }
        });
        bntfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntfiltrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por Genero:");

        jLabel9.setText("Total de Registros:");

        labtotr.setText("0");

        jLabel10.setText("Suma de Registros Listados:");

        lablis.setText("0");

        jLabel11.setText("Promedio de Peliculas Listadas:");

        labpro.setText("0");

        javax.swing.GroupLayout form_listadoLayout = new javax.swing.GroupLayout(form_listado.getContentPane());
        form_listado.getContentPane().setLayout(form_listadoLayout);
        form_listadoLayout.setHorizontalGroup(
            form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_listadoLayout.createSequentialGroup()
                .addGroup(form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form_listadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(form_listadoLayout.createSequentialGroup()
                        .addGroup(form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(form_listadoLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1)
                                .addGap(195, 195, 195)
                                .addComponent(cbofiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntfiltrar))
                            .addGroup(form_listadoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labtotr)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lablis)
                                .addGap(146, 146, 146)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labpro)))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        form_listadoLayout.setVerticalGroup(
            form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form_listadoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbofiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntfiltrar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(form_listadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labtotr)
                    .addComponent(jLabel10)
                    .addComponent(lablis)
                    .addComponent(jLabel11)
                    .addComponent(labpro))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador de cartelera");

        Archivo.setMnemonic('a');
        Archivo.setText("Archivo");

        item_registro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        item_registro.setText("Registro");
        item_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_registroActionPerformed(evt);
            }
        });
        Archivo.add(item_registro);

        item_listado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        item_listado.setText("Listado");
        item_listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listadoActionPerformed(evt);
            }
        });
        Archivo.add(item_listado);

        item_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        item_salir.setText("Salir");
        item_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salirActionPerformed(evt);
            }
        });
        Archivo.add(item_salir);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_registroActionPerformed
        form_registro.setSize(470, 410);
        form_registro.setLocationRelativeTo(this);
        form_registro.setAlwaysOnTop(false);
        form_registro.setVisible(true);
    }//GEN-LAST:event_item_registroActionPerformed

    private void item_listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listadoActionPerformed
        form_listado.setSize(920, 576);
        form_listado.setLocationRelativeTo(this);
        form_listado.setAlwaysOnTop(false);
        form_listado.setVisible(true);
        actualizarGrilla();
    }//GEN-LAST:event_item_listadoActionPerformed

    private void item_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_item_salirActionPerformed

    private void bntfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntfiltrarActionPerformed
        actualizarGrilla();
    }//GEN-LAST:event_bntfiltrarActionPerformed

    private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
        validar();
    }//GEN-LAST:event_btnbusActionPerformed

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        if (txtcod.getText().length() >= 6) {
            evt.consume();
        }

    }//GEN-LAST:event_txtcodKeyTyped

    private void txtfecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
        if (txtfec.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfecKeyTyped

    private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
        if (!Character.isAlphabetic(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())) {
            evt.consume();
        }
        if (txtnom.getText().length() >= 35) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnomKeyTyped

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        if (txtcod.getText().isEmpty() || txtcod.getText().trim().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Debe llenar la casilla (Codigo)");
            return;
        }
        if (txtnom.getText().isEmpty() || txtnom.getText().trim().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Debe llenar la casilla (Nombre)");
            return;
        }
        if (cbogen.getSelectedIndex() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "debe seleccionar un genero");
            return;
        }
        if (rbntod.isSelected() == false) {
            if (rbn15.isSelected() == false) {
                if (rbn18.isSelected() == false) {
                    javax.swing.JOptionPane.showMessageDialog(item_registro, "debe seleccionar una clasificacion");
                    return;
                }
            }
        }
        if (txtfec.getText().trim().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Debe llenar la casilla (Año de Estreno)");
            return;
        }
        cod = txtcod.getText();
        nom = txtnom.getText();
        gen = cbogen.getSelectedItem().toString();
        if (rbntod.isSelected() == true) {
            cla = rbntod.getText();
        } else {
            if (rbn15.isSelected() == true) {
                cla = rbn15.getText();
            } else {
                cla = rbn18.getText();
            }
        }
        fec = Integer.parseInt(txtfec.getText());
        p = new Peliculas(cod, nom, gen, cla, fec);
        if (a.registrarPelicula(p) == true) {
            actualizarGrilla();
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Registro realizado con exito");
            txtnom.setText("");
            txtnom.setEnabled(false);
            cbogen.setSelectedIndex(0);
            cbogen.setEnabled(false);
            rbntod.setSelected(false);
            rbntod.setEnabled(false);
            rbn15.setSelected(false);
            rbn15.setEnabled(false);
            rbn18.setSelected(false);
            rbn18.setEnabled(false);
            txtfec.setText("");
            txtfec.setEnabled(false);
            btneli.setEnabled(false);
            btnmod.setEnabled(false);
            btnreg.setEnabled(false);
        } else {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Registro Erroneo");
        }


    }//GEN-LAST:event_btnregActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        cod = txtcod.getText();
        if (a.eliminarPelicula(cod) == true) {
            txtcod.setText("");
            txtnom.setText("");
            txtnom.setEnabled(false);
            cbogen.setSelectedIndex(0);
            cbogen.setEnabled(false);
            rbntod.setSelected(false);
            rbntod.setEnabled(false);
            rbn15.setSelected(false);
            rbn15.setEnabled(false);
            rbn18.setSelected(false);
            rbn18.setEnabled(false);
            txtfec.setText("");
            txtfec.setEnabled(false);
            btneli.setEnabled(false);
            btnmod.setEnabled(false);
            btnreg.setEnabled(false);
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Registro eliminado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "no se elimino la pelicula");
        }
        actualizarGrilla();
    }//GEN-LAST:event_btneliActionPerformed

    private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodActionPerformed
        if (txtnom.getText().isEmpty() || txtnom.getText().trim().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Debe llenar la casilla (Nombre)");
            return;
        }
        if (cbogen.getSelectedIndex() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "debe seleccionar un genero");
        }
        if (rbntod.isSelected() == false) {
            if (rbn15.isSelected() == false) {
                if (rbn18.isSelected() == false) {
                    javax.swing.JOptionPane.showMessageDialog(item_registro, "debe seleccionar una clasificacion");
                }
            }
        }
        if (txtfec.getText().trim().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(item_registro, "Debe llenar la casilla (Año de Estreno)");
        }
        String x;// se supone que deberia tomar el valor de los radiobuttons
        for (int i = 0; i < lispel.size(); i++) {
            p = lispel.get(i);
            if (txtcod.getText().equalsIgnoreCase(p.getCodigo())) {
                System.out.println("Vista.Principal.btnmodActionPerformed(t)");
                if (rbntod.isSelected() == true) {
                    x = rbntod.getText();
                } else {
                    if (rbn15.isSelected() == true) {
                        x = rbn15.getText();
                    } else {
                        x = rbn18.getText();
                    }
                }
                p.setCodigo(txtcod.getText());
                p.setNombre(txtnom.getText());
                p.setGenero(cbogen.getSelectedItem().toString());
                p.setClasificacion(x);
                p.setFecha(Integer.parseInt(txtfec.getText()));
                if (a.modificarPelicula(p) == true) {
                    txtcod.setText("");
                    txtnom.setText("");
                    txtnom.setEnabled(false);
                    cbogen.setSelectedIndex(0);
                    cbogen.setEnabled(false);
                    rbntod.setSelected(false);
                    rbntod.setEnabled(false);
                    rbn15.setSelected(false);
                    rbn15.setEnabled(false);
                    rbn18.setSelected(false);
                    rbn18.setEnabled(false);
                    txtfec.setText("");
                    txtfec.setEnabled(false);
                    btneli.setEnabled(false);
                    btnmod.setEnabled(false);
                    btnreg.setEnabled(false);
                    javax.swing.JOptionPane.showMessageDialog(item_registro, "Registro modificado");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(item_registro, "Registro Erroneo");
                }
            }
        }
        actualizarGrilla();

    }//GEN-LAST:event_btnmodActionPerformed

    private void bntfiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntfiltrarMouseClicked
        actualizarGrilla();
    }//GEN-LAST:event_bntfiltrarMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JButton bntfiltrar;
    private javax.swing.JButton btnbus;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnmod;
    private javax.swing.JButton btnreg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbofiltros;
    private javax.swing.JComboBox<String> cbogen;
    private javax.swing.JFrame form_listado;
    private javax.swing.JFrame form_registro;
    private javax.swing.JTable grilla;
    private javax.swing.JMenuItem item_listado;
    private javax.swing.JMenuItem item_registro;
    private javax.swing.JMenuItem item_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labest;
    private javax.swing.JLabel lablis;
    private javax.swing.JLabel labpro;
    private javax.swing.JLabel labtotr;
    private javax.swing.JRadioButton rbn15;
    private javax.swing.JRadioButton rbn18;
    private javax.swing.JRadioButton rbntod;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtfec;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
