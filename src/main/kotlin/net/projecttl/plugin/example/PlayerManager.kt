import org.hibernate.Session
import org.hibernate.SessionFactory
import java.lang.module.Configuration

class PlayerManager (){

    fun getPlayerByUUID(uuid: String): PlayerEntity? {

            // Konfiguration erstellen
            val configuration = org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")

            // SessionFactory erstellen
            val sessionFactory: SessionFactory = configuration.buildSessionFactory()

            // Neue Session öffnen
            val session: Session = sessionFactory.openSession()

            // Spieler anhand der ID aus der Datenbank abfragen
            val playerId = 1 // Hier die ID des Spielers eintragen
            val player = session.get(PlayerEntity::class.java, playerId)

            if (player != null) {
                // Spielerinformationen ausgeben
                println("UUID: ${player.uuid}")
                println("Rang: ${player.rang}")
                println("Geld: ${player.geld}")
                println("Infos: ${player.infos}")
            } else {
                println("Spieler nicht gefunden.")
            }

            // Session schließen
            session.close()

            // SessionFactory schließen
            sessionFactory.close()
        return player
    }
}