import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;

public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer service;

    public void buildGui() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        Object[] services = getServicesList();
        serviceList = new JComboBox<>(services);
        frame.getContentPane().add(BorderLayout.NORTH,serviceList);
        serviceList.addActionListener(new MyListListener());
        frame.setSize(500,500);
        frame.setVisible(true);
    }//close the guildGui method

    public class MyListListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }//close the inner class MyListListener

    public Object[] getServicesList(){
        Object[] services = null;
        Object obj = null;
        try {                                                       //connect to the stub
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        server = (ServiceServer)obj;                                //cast the return obj to desired type
        try {
            services = server.getServiceList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;
    }//close the getServicesList method

    public void loadService (Object selectedServ) {
        try {
            Service svc = service.getService(selectedServ);
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//close the loadService method

    public static void main(String[] args) {
        new ServiceBrowser().buildGui();
    }
}
