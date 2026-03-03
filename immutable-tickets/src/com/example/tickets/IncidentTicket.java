package com.example.tickets;

// import java.util.ArrayList;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;         // e.g. "CLI", "WEBHOOK", "EMAIL"

    private IncidentTicket(Builder b) {
        // this.tags = new ArrayList<>();
        this.id=b.id;
        this.reporterEmail=b.reporterEmail;
        this.title=b.title;
        this.description=b.description;
        this.priority=b.priority;
        this.tags=List.copyOf(b.tags);
        this.assigneeEmail=b.assigneeEmail;
        this.customerVisible=b.customerVisible;
        this.slaMinutes=b.slaMinutes;
        this.source=b.source;
    }
    public static class Builder{
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority;       // LOW, MEDIUM, HIGH, CRITICAL
        private List<String> tags;     // mutable leak
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;    // optional
        private String source;
        public Builder(String id,String re,String title){
            this.id=id;
            this.title=title;
            this.reporterEmail=re;
        }
        // public Builder setId(String id){
        //     this.id=id;
        //     return this;
        // }
        // public Builder setReporterEmail(String re){
        //     this.reporterEmail=re;
        //     return this;
        // }
        // public Builder setTitle(String title){
        //     this.title=title;
        //     return this;
        // }
        public Builder setDescription(String des){
            this.description=des;
            return this;
        }
        public Builder setPriority(String p){
            this.priority=p;
            return this;
        }
        public Builder setAssigneeEmail(String e){
            this.assigneeEmail=e;
            return this;
        }
        public Builder setCustomerVisible(boolean vis){
            this.customerVisible=vis;
            return this;
        }
        public Builder setSlaMinutes(Integer min){
            this.slaMinutes=min;
            return this;
        }
        public Builder setSource(String s){
            this.source=s;
            return this;
        }
        public Builder setTags(List<String> tags){
            // this.tags=tags; in his it can still leake, hence to ensure no leakage we store a copy here as well
            this.tags = tags == null ? List.of() : List.copyOf(tags);
            return this;
        }
        public IncidentTicket build(){
            //HERE WE NEED TO IMPLEMENT CENTRALIZED VALIDATION
            Validation.requireTicketId(id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireNonBlank(title,"title");
            Validation.requireMaxLen(title,80,"title");
            Validation.requireOneOf(priority,"priority","MEDIUM","HIGH","LOW","CRITICAL");
            Validation.requireRange(slaMinutes,5,7200,"slaMinutes");
            Validation.requireEmailIfPresent(assigneeEmail, "assigneeEmail");
            return new IncidentTicket(this);
        }
        
    }
    //TOBUILDER METHOD IS BUID OUTSIDE BUILDER CLASS
    public Builder toBuilder(){
        return new Builder(id,reporterEmail,title).setDescription(description).setAssigneeEmail(assigneeEmail).setCustomerVisible(customerVisible).setPriority(priority).setTags(tags).setSlaMinutes(slaMinutes).setSource(source);
    }

    // public IncidentTicket(String id, String reporterEmail, String title) {
    //     this();
    //     this.id = id;
    //     this.reporterEmail = reporterEmail;
    //     this.title = title;
    // }

    // public IncidentTicket(String id, String reporterEmail, String title, String priority) {
    //     this(id, reporterEmail, title);
    //     this.priority = priority;
    // }

    // Getters
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return tags; } // BROKEN: leaks internal list
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    // Setters (BROKEN: should not exist after refactor)
    // public void setId(String id) { this.id = id; }
    // public void setReporterEmail(String reporterEmail) { this.reporterEmail = reporterEmail; }
    // public void setTitle(String title) { this.title = title; }
    // public void setDescription(String description) { this.description = description; }
    // public void setPriority(String priority) { this.priority = priority; }
    // public void setTags(List<String> tags) { this.tags = tags; } // BROKEN: retains external reference
    // public void setAssigneeEmail(String assigneeEmail) { this.assigneeEmail = assigneeEmail; }
    // public void setCustomerVisible(boolean customerVisible) { this.customerVisible = customerVisible; }
    // public void setSlaMinutes(Integer slaMinutes) { this.slaMinutes = slaMinutes; }
    // public void setSource(String source) { this.source = source; }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }
}
