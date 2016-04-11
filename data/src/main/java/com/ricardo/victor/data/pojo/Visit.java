package com.ricardo.victor.data.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visit {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("datetimeReserv")
    @Expose
    private String datetimeReserv;
    @SerializedName("datetimeArriva")
    @Expose
    private String datetimeArriva;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("person_id")
    @Expose
    private String personId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The datetimeReserv
     */
    public String getDatetimeReserv() {
        return datetimeReserv;
    }

    /**
     *
     * @param datetimeReserv
     * The datetimeReserv
     */
    public void setDatetimeReserv(String datetimeReserv) {
        this.datetimeReserv = datetimeReserv;
    }

    /**
     *
     * @return
     * The datetimeArriva
     */
    public String getDatetimeArriva() {
        return datetimeArriva;
    }

    /**
     *
     * @param datetimeArriva
     * The datetimeArriva
     */
    public void setDatetimeArriva(String datetimeArriva) {
        this.datetimeArriva = datetimeArriva;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The personId
     */
    public String getPersonId() {
        return personId;
    }

    /**
     *
     * @param personId
     * The person_id
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}