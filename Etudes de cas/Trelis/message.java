class Message
{
	private String code, description;
	private int duree;
	private LinkedList<Diffusion> lesDiffusions;
	
	public String toXML();
	public LinkedList<Diffusion> getLesDiffusions();
	
	public boolean estDiffusee()
	{
		return (lesDiffusions.cardinal() > 0);
	}
	
	public int compare(Message unMessage)
	{
		if(duree == unMessage.duree)
		{
			return 0;
		}
		else if (duree > unMessage.duree)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}