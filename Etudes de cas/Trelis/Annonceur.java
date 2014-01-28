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
			trierLesMessages(messages);
		}
	}
	
	public void trierLesMessages(LinkedList<Message> messagesATrier)
	{
		Message temp;
		for(Messages unMessage : messagesATrier)
		{
			temp = unMessage;
			if(unMessage.compare() == 1)
			{
				messagesATrier.set(messagesATrier.indexOf(unMessage), messagesATrier.get(messagesATrier.indexOf(unMessage)+1));
				messagesATrier.set(messagesATrier.get(messagesATrier.indexOf(unMessage)+1), temp);
			} else if (unMessage.commpare() == -1)
			{
				messagesATrier.set(messagesATrier.indexOf(unMessage), messagesATrier.get(messagesATrier.indexOf(unMessage)-1));
				messagesATrier.set(messagesATrier.get(messagesATrier.indexOf(unMessage)-1), temp);
			}
		}
	}
}