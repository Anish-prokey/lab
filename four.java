package question4;

public class Shop implements ActionListener {
	static	HashMap<String , String> user = new HashMap<String,String>();
	static ArrayList<Item> it = new ArrayList<Item>();
	static HashMap<Long , Integer> cid = new HashMap<Long,Integer>();
	
	String un = "",pw ="";
	int id ;
	double total = 0.0;
	JTextField userid,phno,Itemid,quan,name;
	JButton submit;
	Shop(){
		user.put("sac","1254");
		user.put("sud","9876");
		while(!user.containsKey(un) || !user.containsValue(pw)) {
			un = JOptionPane.showInputDialog(null,"Enter username");
			if(!user.containsKey(un)) {
				JOptionPane.showMessageDialog(null, "Invalid user");
			}
			else {
				if(user.containsKey(un)) {
					pw = JOptionPane.showInputDialog(null,"Enter password");
					if(pw.equals(user.get(un))) {
					break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid password");
					}
				}
			}
		}
		
		long ph = Long.parseLong(JOptionPane.showInputDialog(null,"Enter phone number"));
		if(cid.containsKey(ph)) {
			id = cid.get(ph);
			JOptionPane.showMessageDialog(null, "welcome "+id);
		}
		else {
			id = Integer.parseInt(JOptionPane.showInputDialog(null,"new user id"));
			cid.put(ph, id);
		}
		JFrame frm = new JFrame("Details");
		JLabel name1 = new JLabel("user");
		JLabel ph1 = new JLabel("Phone number");
		JLabel id1 = new JLabel("item id");
		JLabel q1 = new JLabel("Quantity");
		JLabel n1 = new JLabel("Item name");
		userid = new JTextField(20);
		phno = new JTextField(40);
		Itemid = new JTextField(20);
		quan = new JTextField(20);
		name = new JTextField(20);
		submit = new JButton("Submit");
		frm.add(name1);
		frm.add(userid);
		userid.setText(String.valueOf(id));	
		userid.setEditable(false);
		frm.add(ph1);
		frm.add(phno);
		phno.setText(String.valueOf(ph));
		phno.setEditable(false);
		frm.add(id1);
		frm.add(Itemid);
		frm.add(q1);
		frm.add(quan);
		frm.add(n1);
		frm.add(name);
		frm.add(submit);
		submit.addActionListener(this);
		frm.setSize(1000,1000);
		frm.setVisible(true);
		frm.setLayout(new GridLayout(6, 2));
	}
	public void actionPerformed(ActionEvent e) {
		String itid = Itemid.getText();
		int itq = Integer.parseInt(quan.getText());
		String itna = name.getText();
		
		 String discount[] = {"5","10","15"};
		 int r = JOptionPane.showOptionDialog(null, "select discount", "Discount", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE	, null, discount, discount[0]);
		 for(Item a:it) {
			 if(a.id.equals(itid))
				 total = itq * a.price;
		 }
		 total = total -(total * 0.01*Integer.parseInt(discount[r]));
		  String t = String.valueOf(total);
		  JOptionPane.showMessageDialog(null, "total for :"+itna+" is" +t);
	}
	
	public static void main(String[] args) {
		cid.put((long)900080078,1);
		it.add(new Item("gum","5",5));
		it.add(new Item("gun","1",55000));
		it.add(new Item("cat","2",4000));
		Shop obj = new Shop();
	}
}


public class Item {
	String name,id;
	int price;
	Item(String name,String id,int price){
		this.name = name;
		this.id = id ;
		this.price = price;
	}
	public String toString() {
		return ("Item name :"+name+"Item id :"+id+"item Price :"+price);
		
	}
}
