package model;

@Entity
@Table (name = "client")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(name = "client_name")
	private boolean type;
}
