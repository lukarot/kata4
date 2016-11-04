package kata4;
import java.awt.Dimension;
import org.jfree.ui.ApplicationFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histo;
    public HistogramDisplay(Histogram<String> histo) {
        super("histograma");
        this.histo=histo;
        setContentPane(createPanel());
        setLocationRelativeTo(null);
        pack();
    }
    public void execute(){
        setVisible(true);
    }
    private JPanel createPanel(){
        ChartPanel chartPanel=new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(400,500));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart=ChartFactory.createBarChart(
                "titulo", 
                "dominio email", 
                "número de email", 
                dataSet, 
                PlotOrientation.VERTICAL, 
                true, 
                rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled
                );
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
        for (String key : histo.keyset()) {
            dataSet.addValue(histo.get(key), key, key);
        }
        return dataSet;    
    }
    
}