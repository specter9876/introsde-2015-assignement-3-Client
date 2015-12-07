
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per healthMeasureHistory complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="healthMeasureHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idMeasureDefinition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idMeasureHistory" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measureDefinition" type="{http://soap.assignment.introsde/}measureDefinition" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthMeasureHistory", propOrder = {
    "idMeasureDefinition",
    "idMeasureHistory",
    "measureDefinition",
    "timestamp",
    "value"
})
public class HealthMeasureHistory {

    protected int idMeasureDefinition;
    protected int idMeasureHistory;
    protected MeasureDefinition measureDefinition;
    protected String timestamp;
    protected String value;

    /**
     * Recupera il valore della proprietà idMeasureDefinition.
     * 
     */
    public int getIdMeasureDefinition() {
        return idMeasureDefinition;
    }

    /**
     * Imposta il valore della proprietà idMeasureDefinition.
     * 
     */
    public void setIdMeasureDefinition(int value) {
        this.idMeasureDefinition = value;
    }

    /**
     * Recupera il valore della proprietà idMeasureHistory.
     * 
     */
    public int getIdMeasureHistory() {
        return idMeasureHistory;
    }

    /**
     * Imposta il valore della proprietà idMeasureHistory.
     * 
     */
    public void setIdMeasureHistory(int value) {
        this.idMeasureHistory = value;
    }

    /**
     * Recupera il valore della proprietà measureDefinition.
     * 
     * @return
     *     possible object is
     *     {@link MeasureDefinition }
     *     
     */
    public MeasureDefinition getMeasureDefinition() {
        return measureDefinition;
    }

    /**
     * Imposta il valore della proprietà measureDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureDefinition }
     *     
     */
    public void setMeasureDefinition(MeasureDefinition value) {
        this.measureDefinition = value;
    }

    /**
     * Recupera il valore della proprietà timestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Imposta il valore della proprietà timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Recupera il valore della proprietà value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Imposta il valore della proprietà value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
