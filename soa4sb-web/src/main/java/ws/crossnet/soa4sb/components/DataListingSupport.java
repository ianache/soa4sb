package ws.crossnet.soa4sb.components;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import org.apache.myfaces.custom.datascroller.ScrollerActionEvent;

public abstract class DataListingSupport<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = -4424569257831079775L;
	private int recordCount = 0;
	private int totalPages = 0;
	private DataModel<T> data;
	
	private int page = 1;
    private Integer rowsPerPage = null;
    private boolean ascending = true;
    private String sortField;

    public void navigatePage(final boolean forward) {
        setPage((forward) ? ++page : --page);
        refresh();
    }

    public void sort(final String sortField) {
        setSortField(sortField);
        setAscending(getSortField().equals(sortField) ? !isAscending() : true);
        refresh();
    }

    public void updateRowsPerPage(final AjaxBehaviorEvent event) {
    	System.out.println("Actualizando Registros por Pagina a: " + rowsPerPage);
        setPage(1); // page must reset to the first one
        refresh();
    }

    public void refresh() {
        // hook to populate count and data
        populateCountAndData();
        // compute total pages
        setTotalPages(countTotalPages(getRecordCount(), getRowsPerPage()));
    }

    /**
     * The concreate implementation of this class must perform data retrieval
     * based on the current information available (accessible via methods such
     * as {@link #getSortField()}, {@link #isAscending()}, etc.
     * <p>
     * The implementation is responsible in populating the values for {@link #setRecordCount(int)}
     * and {@link #setData(javax.faces.model.DataModel)}
     */
    protected abstract void populateCountAndData();

    /************************************************************** HELPER(S) */

    private static int countTotalPages(int totalRecord, int rowsPerPage) {
        int pageCounter = 0;
        for (int pageCountTracker = 0; pageCountTracker < totalRecord; ++pageCounter) {
            pageCountTracker += rowsPerPage;
        }
        return pageCounter;
    }

    /************************************************* ACCESSORS AND MUTATORS */

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public Integer getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(Integer rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public DataModel<T> getData() {
        return data;
    }

    public void setData(DataModel<T> data) {
        this.data = data;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    public int getFirstRow() {
    	return (1+(rowsPerPage * (page - 1)));
    }

    public void scrollerAction(ActionEvent event)
    {
        ScrollerActionEvent scrollerEvent = (ScrollerActionEvent) event;
        FacesContext.getCurrentInstance().getExternalContext().log(
                        "scrollerAction: facet: "
                                        + scrollerEvent.getScrollerfacet()
                                        + ", pageindex: "
                                        + scrollerEvent.getPageIndex());
    }
}
