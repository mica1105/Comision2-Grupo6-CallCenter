/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.vistas;

import InstitutoAbiertoModelo.*;

import institutoAbiertoModelo.Conexion;
import institutoAbiertoModelo.Curso;
import institutoAbiertoModelo.CursoData;
import institutoAbiertoModelo.Persona;
import institutoAbiertoModelo.PersonaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Vaio
 */
public class VistaCurso extends javax.swing.JInternalFrame {
     private CursoData cursoData;
     private Conexion conexion;
     private ArrayList<Persona> listaPersonas;
     private PersonaData personaData;
    /**
     * Creates new form VistaCurso
     */
    public VistaCurso() {
        initComponents();        
        try {   
            conexion = new Conexion("jdbc:mysql://localhost/InstitutoAbierto", "root", "");
                         
            cursoData = new CursoData(conexion);
            
            personaData = new PersonaData(conexion);
            listaPersonas=(ArrayList)personaData.obtenerPersonas();
            
            //Método encargado de llenar el combobox
            cargaPersona();
            
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VistaCurso.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cId = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cCupo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cCosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Responsable = new javax.swing.JComboBox<>();
        Guardar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 51));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("\"Alta Curso\"");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setText("Id: ");

        cId.setToolTipText("");

        Buscar.setBackground(new java.awt.Color(153, 153, 255));
        Buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Buscar.setForeground(new java.awt.Color(0, 0, 204));
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel5.setText("Cupo:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Costo:  $");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setText("Responsable:");

        Responsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponsableActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(102, 153, 255));
        Guardar.setForeground(new java.awt.Color(0, 0, 153));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(102, 153, 255));
        Actualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(0, 0, 153));
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Borrar.setBackground(new java.awt.Color(102, 153, 255));
        Borrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Borrar.setForeground(new java.awt.Color(0, 0, 153));
        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        Limpiar.setBackground(new java.awt.Color(102, 153, 255));
        Limpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(0, 0, 204));
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(Guardar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(Limpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Actualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Borrar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cDescripcion)
                                        .addComponent(cNombre)
                                        .addComponent(cCosto)
                                        .addComponent(cCupo)
                                        .addComponent(Responsable, 0, 154, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Buscar))))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(cDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(Limpiar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Actualizar)
                    .addComponent(Borrar))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        String nombre=cNombre.getText();
        String descripcion=cDescripcion.getText();
        int cupo=Integer.parseInt(cCupo.getText());
        int costo=Integer.parseInt(cCosto.getText());
        Persona p=(Persona)Responsable.getSelectedItem();
        
        Curso curso=new Curso(nombre,descripcion,cupo,costo,p);
        cursoData.guardarCurso(curso);
        
        cId.setText(curso.getId()+"");
    }//GEN-LAST:event_GuardarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        
        int id=Integer.parseInt(cId.getText());
        System.out.println("idcurso "+id);
        Curso curso=cursoData.buscarCurso(id);
        if(curso!=null){
                cId.setText(curso.getId()+"");
                cNombre.setText(curso.getNombre());
                cDescripcion.setText(curso.getDescripcion());
                cCupo.setText(curso.getCupo()+"");
                cCosto.setText(curso.getCosto()+"");
                Responsable.setSelectedItem(curso.getPersona().getId()+"-"+curso.getPersona().getNombre());
                //Persona p=(Persona)Responsable.getSelectedItem();
        }           
    }//GEN-LAST:event_BuscarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(cId.getText());
        cursoData.borrarCurso(id);
    }//GEN-LAST:event_BorrarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
            if (cId.getText()!=null){
            String nombre=cNombre.getText();
            String descripcion=cDescripcion.getText();
            int cupo=Integer.parseInt(cCupo.getText());
            int costo=Integer.parseInt(cCosto.getText());           
            Persona p=(Persona)Responsable.getSelectedItem();
            
            Curso curso=new Curso(nombre,descripcion,cupo,costo,p);
             cursoData.actualizarCurso(curso);      
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void ResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponsableActionPerformed
        // TODO add your handling code here:
       cargaPersona();
        
    }//GEN-LAST:event_ResponsableActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:}
        cId.setText("");
        cNombre.setText("");
        cDescripcion.setText("");
        cCupo.setText("");
        cCosto.setText("");
        
    }//GEN-LAST:event_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JComboBox<Persona> Responsable;
    private javax.swing.JTextField cCosto;
    private javax.swing.JTextField cCupo;
    private javax.swing.JTextField cDescripcion;
    private javax.swing.JTextField cId;
    private javax.swing.JTextField cNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables


public void cargaPersona(){
    
     for(Persona item:listaPersonas){
            Responsable.addItem(item);
    }
}
}
