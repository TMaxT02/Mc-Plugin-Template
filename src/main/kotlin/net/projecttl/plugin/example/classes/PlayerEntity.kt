import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "player") // Tabellenname festlegen
class PlayerEntity (
    @Id
    @Column(name = "uuid") // Spaltenname festlegen
    var uuid: Int,

    @Column(name = "rang") // Spaltenname festlegen
    var rang: String,

    @Column(name = "geld") // Spaltenname festlegen
    var geld: Int,

    @Column(name = "infos") // Spaltenname festlegen
    var infos: Int,
)
