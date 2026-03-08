package com.example.reports;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Concrete class used directly by clients
 * - Expensive load happens every time display() is called
 * - No access control
 *
 * TODO (student):
 * - Convert this into the RealSubject behind a Proxy, or replace with RealReport.
 */
public class ReportFile {

    private final String reportId;
    private final String title;
    private final String classification; // PUBLIC / FACULTY / ADMIN

    public ReportFile(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }    
}
//NO USE OF THIS FILE
//WHAT IS HAPPENING IN THIS WE HAVE PUT ALL THE CHECKING AND ALL OF IT IN REPORTPROXY AND ONCE WE GET ALL THESE THINGS WE CHECK
//IF THIS FILE IS STORED IN REALREPORT, IF NOT WE WILL SAVE IT LAZILY AND RETURN FROM THERE OR ELSE WE WILL RETURN IT DIRECTLY!!