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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Alta Curso");

        jLabel2.setText("Id: ");

        cId.setToolTipText("");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Cupo:");

        jLabel6.setText("Costo:");

        jLabel7.setText("Responsable:");

        Responsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponsableActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Guardar)
                                .addGap(38, 38, 38)
                                .addComponent(Actualizar)
                                .addGap(40, 40, 40)
                                .addComponent(Borrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Buscar))
                                    .addComponent(cDescripcion)
                                    .addComponent(cNombre)
                                    .addComponent(Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cCosto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(cCupo, javax.swing.GroupLayout.Alignment.LEADING)))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Actualizar)
                    .addComponent(Borrar))
                .addGap(0, 44, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Guardar;
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
