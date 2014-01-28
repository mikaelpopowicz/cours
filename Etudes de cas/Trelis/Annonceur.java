class Annonceur
{
	public LinkedList<Message> messagesAyantDiffusions()
	{
		LinkedList<Message> messages = new LinkedList<Message>();
		for(Message unMessage : lesMessages)
		{
			if(unMessage.estDiffusee())
			{
				messages.add(unMessage);
			}
		}
	}
}