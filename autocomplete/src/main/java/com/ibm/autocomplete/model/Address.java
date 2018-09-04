package com.ibm.autocomplete.model;

@Entity
@Data
@Table(name = "Address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(name = "town")
    private String town;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Override
    public String toString() {
        return String.format(
            "%s, %s, %s, %s", number, street, suburb, town
        );
    }
}