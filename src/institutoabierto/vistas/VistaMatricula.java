/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.vistas;

import institutoAbiertoModelo.Conexion;
import institutoAbiertoModelo.Curso;
import institutoAbiertoModelo.CursoData;
import institutoAbiertoModelo.Matricula;
import institutoAbiertoModelo.MatriculaData;
import institutoAbiertoModelo.Persona;
import institutoAbiertoModelo.PersonaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Matias
 */
public class VistaMatricula extends javax.swing.JInternalFrame {
    private MatriculaData matriculaData;
    private Conexion conexion;
    private ArrayList <Persona> listaPersonas;
    private PersonaData personaData;
    private ArrayList <Curso> listaCursos;
    private CursoData cursoData;
    
    
    /**
     * Creates new form VistaMatricula
     */
    public VistaMatricula() {
        initComponents();
        try {   
            conexion = new Conexion("jdbc:mysql://localhost/InstitutoAbierto", "root", "");
            matriculaData= new MatriculaData(conexion);             
            cursoData = new CursoData(conexion); 
            personaData = new PersonaData(conexion);
            listaPersonas=(ArrayList)personaData.obtenerPersonas();
            cursoData= new CursoData(conexion);
            listaCursos=(ArrayList)cursoData.obtenerCursos();
            //Método encargado de llenar el combobox
            cargarPersonas();
            cargarCursos ();
            
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
        btBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtCosto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbCursos = new javax.swing.JComboBox<>();
        btGuardar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        jtId = new javax.swing.JTextField();
        cbPersonas = new javax.swing.JComboBox<>();
        jtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 0));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("\"Matriculación\"");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setText("Id:");

        btBuscar.setBackground(new java.awt.Color(153, 153, 255));
        btBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBuscar.setForeground(new java.awt.Color(0, 0, 102));
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de Inscripcion:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setText("Costo:");

        jLabel5.setText("$");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Alumno:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setText("Curso:");

        cbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCursosActionPerformed(evt);
            }
        });

        btGuardar.setBackground(new java.awt.Color(153, 153, 255));
        btGuardar.setForeground(new java.awt.Color(0, 0, 102));
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btLimpiar.setBackground(new java.awt.Color(153, 153, 255));
        btLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btLimpiar.setForeground(new java.awt.Color(0, 0, 102));
        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btBorrar.setBackground(new java.awt.Color(153, 153, 255));
        btBorrar.setForeground(new java.awt.Color(0, 0, 102));
        btBorrar.setText("Anular");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        cbPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonasActionPerformed(evt);
            }
        });

        jLabel8.setText("*El costo de matriculacion es proporcional al costo de curso");

        jLabel9.setText("dd/MM/aaaa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBuscar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(btGuardar)
                            .addGap(37, 37, 37)
                            .addComponent(btBorrar)
                            .addGap(37, 37, 37)
                            .addComponent(btLimpiar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btLimpiar)
                    .addComponent(btBorrar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonasActionPerformed
        // TODO add your handling code here:
        cargarPersonas();
    }//GEN-LAST:event_cbPersonasActionPerformed

    private void cbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursosActionPerformed
        // TODO add your handling code here:
        cargarCursos();
    }//GEN-LAST:event_cbCursosActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        LocalDate fechaInscripcion= LocalDate.parse(jtFecha.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int costo=Integer.parseInt(jtCosto.getText());
        Persona p=(Persona)cbPersonas.getSelectedItem();
        Curso c= (Curso) cbCursos.getSelectedItem();
       Matricula matricula = new Matricula (fechaInscripcion,costo, p, c);
       if(cursoData.hayDisponibilidad(c.getId())&& c.getCosto()== costo){
        matriculaData.guardarMatricula(matricula);
       jtId.setText(matricula.getId()+"");
       } else{
           JOptionPane.showMessageDialog(this, "El curso seleccionado no cuenta con cupo disponible o el costo ingresado no es correcto", "ERROR LA MATRICULA NO SE HA GUARDADO", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
         Persona p=(Persona)cbPersonas.getSelectedItem();
         Curso c= (Curso) cbCursos.getSelectedItem();
         MatriculaData md= new MatriculaData(conexion);
        md.borrarMatriculaDeUnCursoDeunaPersona(p.getId(), c.getId());
        
    }//GEN-LAST:event_btBorrarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        jtId.setText("");
        jtFecha.setText("");
        jtCosto.setText("");
        
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        int id_Matricula = Integer.parseInt(jtId.getText());
        System.out.println("id_Matricula"+id_Matricula);
        Matricula matricula= matriculaData.buscarMatricula(id_Matricula);
        if(matricula!=null){
                jtId.setText(matricula.getId()+"");
                jtFecha.setText(matricula.getFechaInscripcion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                jtCosto.setText(matricula.getCosto()+"");
                cbPersonas.setSelectedItem(matricula.getPersona().getId()+"-"+matricula.getPersona().getNombre());
                cbCursos.setSelectedItem(matricula.getCurso().getId()+"-"+matricula.getCurso().getNombre());
                //Persona p=(Persona)Responsable.getSelectedItem();
        }else{
            JOptionPane.showMessageDialog(this, "El id ingresado no se encuentra registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btBuscarActionPerformed
    }
    private void cargarPersonas(){
        for(Persona item: listaPersonas){
            cbPersonas.addItem(item);
        }
    }
    private void cargarCursos(){
        for(Curso item: listaCursos){
            cbCursos.addItem(item);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JComboBox<Curso> cbCursos;
    private javax.swing.JComboBox<Persona> cbPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtCosto;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtId;
    // End of variables declaration//GEN-END:variables
}
