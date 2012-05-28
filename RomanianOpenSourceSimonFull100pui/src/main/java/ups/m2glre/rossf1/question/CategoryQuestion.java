package ups.m2glre.rossf1.question;

/** 
 * Category question model.
 */
public class CategoryQuestion extends GenericQuestion {
    private String categoryText;

    /**
     * @return the categoryText
     */
    public final String getCategoryText() {
        return categoryText;
    }

    /**
     * @param categoryText the categoryText to set
     */
    public final void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }
}
