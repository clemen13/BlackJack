package game;

import model.Carta;
import model.Baraja;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author cleme
 */
public class BlackJackGame extends javax.swing.JFrame {

    
    Baraja baraja;
    JLabel[] mano = new JLabel[6];
    int PosMano = 0;
    boolean As = false, AsCrupier = false;
    int puntos = 0, puntosCrupier = 0;
    int dinero = 10000;
    boolean termina = false;

    // Constructor de la ventana del juego
    public BlackJackGame() {
        initComponents();
        this.setFocusable(true);
        this.requestFocusInWindow();
        Comenzar();
    }

    // Método para iniciar una nueva partida
    void Comenzar() {
        baraja = new Baraja();
        fichas.setText("Fichas :" + dinero);
        
        mano[0] = Carta1;
        mano[1] = Carta2;
        mano[2] = Carta3;
        mano[3] = Carta4;
        mano[4] = Carta5;
        mano[5] = Carta6;

         // El jugador recibe dos cartas al inicio
        PedirCarta();
        PedirCarta();
        
    }

    // Método para dar una carta al jugador
    void PedirCarta() {
        Carta cartaMano = baraja.SacaCartaAlAzar();

        // Muestra la carta en la interfaz
        mano[PosMano].setIcon(new javax.swing.ImageIcon(getClass().getResource(cartaMano.nombre)));
        PosMano++;

         // Desactiva el botón si no hay más espacio en la mano 
        if (PosMano >= mano.length){
            BtnPedir.setEnabled(false);
        }
       
        // Los Ases pasan de valer 1 a valer 11
        if (cartaMano.valor == 1){
           puntos += 11; 
           As = true;
        } else{
            puntos += cartaMano.valor;
        }

        // Si te pasas de 21 y tienes un as en la mano, el as pasa a valer 1
        if (As && puntos>21){
            puntos -= 10;
            As = false;
        }

        // Pierdes si te pasas de 21
        if (puntos>21){
            BtnPedir.setEnabled(false);
            BtnPlantarse.setEnabled(false);
            dinero -= 500;
            fichas.setText("Fichas :" + dinero);
            termina = true;
            GameOverInfo.setText("Has perdido");
            EnterInfo.setText("Presiona enter para volver a jugar.");
        }
       
        Puntuación.setText("Puntuación: " + puntos);
        
        

    }

    //logica del crupier
    void Crupier(){
        //va a seguir sacando cartas hasta que no supere o iguale los puntos del jugador
       while (puntosCrupier<puntos){
        Carta crupier = baraja.SacaCartaAlAzar();
        if ((crupier.valor == 1) && (!AsCrupier)){
        puntosCrupier += 11; 
        AsCrupier = true;
        } else{
            puntosCrupier += crupier.valor;
        }
        
        if (AsCrupier && puntosCrupier>21){
            puntosCrupier -= 10;
            AsCrupier = false;
        }
       
        CrupierInfo.setText("Crupier: " + puntosCrupier);
        
        if (puntosCrupier > 21){
            dinero += 500;
            fichas.setText("Fichas :" + dinero);
            termina = true;
            GameOverInfo.setText("Has ganado!!");
            EnterInfo.setText("Presiona enter para volver a jugar.");
            
        }
        
        } // while
        
        if (puntosCrupier>puntos && puntosCrupier<=21){
            dinero -= 500;
            fichas.setText("Fichas :" + dinero);
            GameOverInfo.setText("Has perdido");
            EnterInfo.setText("Presiona enter para volver a jugar.");
            
            
        } else if (puntos>puntosCrupier){
            dinero += 500;
            fichas.setText("Fichas :" + dinero);
            GameOverInfo.setText("Has ganado!!");
            EnterInfo.setText("Presiona enter para volver a jugar.");
           
            
        } else if (puntos == puntosCrupier) {
            GameOverInfo.setText("Habeis empatado");
            EnterInfo.setText("Presiona enter para volver a jugar.");
        } 
        
        termina = true;
        
    } //Crupier

    //Metodo para reiniciar la partida
    void reset(){
        puntos = 0;
        puntosCrupier = 0;
        PosMano = 0;
        baraja.resetBaraja();
        BtnPedir.setEnabled(true);
        As = false;
        AsCrupier = false;
        BtnPlantarse.setEnabled(true);
        termina = false;
        Puntuación.setText("Puntuación: " + puntos);
        CrupierInfo.setText("Crupier: " + puntosCrupier);
        GameOverInfo.setText("");
        EnterInfo.setText("");
        Carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
        Carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
        Carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
        Carta6.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CrupierInfo = new javax.swing.JLabel();
        BtnPedir = new javax.swing.JButton();
        BtnPlantarse = new javax.swing.JButton();
        Carta2 = new javax.swing.JLabel();
        Carta3 = new javax.swing.JLabel();
        Carta4 = new javax.swing.JLabel();
        Carta5 = new javax.swing.JLabel();
        Carta6 = new javax.swing.JLabel();
        Puntuación = new javax.swing.JLabel();
        fichas = new javax.swing.JLabel();
        EnterInfo = new javax.swing.JLabel();
        GameOverInfo = new javax.swing.JLabel();
        Carta1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(30, 120, 60));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));

        CrupierInfo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CrupierInfo.setForeground(new java.awt.Color(255, 255, 255));
        CrupierInfo.setText("Crupier:");

        BtnPedir.setBackground(new java.awt.Color(0, 102, 0));
        BtnPedir.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        BtnPedir.setForeground(new java.awt.Color(255, 255, 255));
        BtnPedir.setText(" Pedir Carta");
        BtnPedir.setActionCommand("Pedir Carta");
        BtnPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPedirActionPerformed(evt);
            }
        });

        BtnPlantarse.setBackground(new java.awt.Color(0, 102, 0));
        BtnPlantarse.setFont(new java.awt.Font("Sans Serif Collection", 1, 12)); // NOI18N
        BtnPlantarse.setForeground(new java.awt.Color(255, 255, 255));
        BtnPlantarse.setText("Plantarse");
        BtnPlantarse.setActionCommand("Pedir Carta");
        BtnPlantarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPlantarseActionPerformed(evt);
            }
        });

        Puntuación.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Puntuación.setForeground(new java.awt.Color(255, 255, 255));
        Puntuación.setText("Puntuación:");
        Puntuación.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                PuntuaciónInputMethodTextChanged(evt);
            }
        });

        fichas.setForeground(new java.awt.Color(255, 255, 255));
        fichas.setText("Fichas");

        EnterInfo.setFont(new java.awt.Font("Sans Serif Collection", 0, 12)); // NOI18N
        EnterInfo.setForeground(new java.awt.Color(255, 255, 255));

        GameOverInfo.setFont(new java.awt.Font("Sans Serif Collection", 0, 18)); // NOI18N
        GameOverInfo.setForeground(new java.awt.Color(255, 255, 255));

        Carta1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(fichas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(EnterInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(BtnPedir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(BtnPlantarse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Carta1)
                        .addGap(6, 6, 6)
                        .addComponent(Carta2)
                        .addGap(6, 6, 6)
                        .addComponent(Carta3)
                        .addGap(6, 6, 6)
                        .addComponent(Carta4)
                        .addGap(6, 6, 6)
                        .addComponent(Carta5)
                        .addGap(6, 6, 6)
                        .addComponent(Carta6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(Puntuación, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(GameOverInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(CrupierInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(fichas)
                .addGap(3, 3, 3)
                .addComponent(CrupierInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(GameOverInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(EnterInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnPedir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPlantarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Carta1)
                    .addComponent(Carta2)
                    .addComponent(Carta3)
                    .addComponent(Carta4)
                    .addComponent(Carta5)
                    .addComponent(Carta6))
                .addGap(12, 12, 12)
                .addComponent(Puntuación, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPedirActionPerformed
        // TODO add your handling code here:
        PedirCarta();
          
    }//GEN-LAST:event_BtnPedirActionPerformed

    private void BtnPlantarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPlantarseActionPerformed
        // TODO add your handling code here:
        BtnPedir.setEnabled(false);
        BtnPlantarse.setEnabled(false);
        Crupier();
        
    }//GEN-LAST:event_BtnPlantarseActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && termina){
            reset();
            Comenzar(); 
        }

            
    }//GEN-LAST:event_formKeyPressed

    private void PuntuaciónInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_PuntuaciónInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_PuntuaciónInputMethodTextChanged

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new BlackJackGame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPedir;
    private javax.swing.JButton BtnPlantarse;
    private javax.swing.JLabel Carta1;
    private javax.swing.JLabel Carta2;
    private javax.swing.JLabel Carta3;
    private javax.swing.JLabel Carta4;
    private javax.swing.JLabel Carta5;
    private javax.swing.JLabel Carta6;
    private javax.swing.JLabel CrupierInfo;
    private javax.swing.JLabel EnterInfo;
    private javax.swing.JLabel GameOverInfo;
    private javax.swing.JLabel Puntuación;
    private javax.swing.JLabel fichas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
