package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)
        // if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id required");
        // if (reporterEmail == null || !reporterEmail.contains("@")) throw new IllegalArgumentException("email invalid");
        // if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title required");

        // IncidentTicket t = new IncidentTicket(id, reporterEmail, title);
        // BAD: mutating after creation
        // t.setPriority("MEDIUM");
        // t.setSource("CLI");
        // t.setCustomerVisible(false);

        List<String> tags = new ArrayList<>();
        tags.add("NEW");
        // t.setTags(tags);

        // return t;
        // Builder b=new Builder();

        return new IncidentTicket.Builder(id,reporterEmail,title).setTags(tags).build();
        //earlier I was getting an error over here such that because my builder class was not static hence inner class was inaccessible 
        //without creating an instance of the outer class
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"
        return t.toBuilder().setPriority("CRITICAL")
        .setTags(appendTag(t.getTags(),"ESCALATED")).build(); // list leak
    }
    private List<String> appendTag(List<String> oldTags, String newTag) {
        return new java.util.ArrayList<>(oldTags) {{
            add(newTag);
        }};
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        // if (assigneeEmail != null && !assigneeEmail.contains("@")) {
        //     throw new IllegalArgumentException("assigneeEmail invalid");
        // }
        return t.toBuilder().setAssigneeEmail(assigneeEmail).build();
    }
}
