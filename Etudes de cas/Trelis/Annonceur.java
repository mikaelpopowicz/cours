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
		/*
			Utilisation de la méthode trier()
			
			messagesATrier.trier();
		*/
		
		
		Message temp;
		boolean permut;
		do {
			permut = false;
			for (int i = 0; i < messagesATrier.size(); i++) {
				if(messagesATrier.get(i).compare(messagesATrier.get(i+1)) == 1)
				{
					messagesATrier.set(messagesATrier.indexOf(unMessage), messagesATrier.get(messagesATrier.indexOf(unMessage)+1));
					messagesATrier.set(messagesATrier.get(messagesATrier.indexOf(unMessage)+1), temp);
					permut = true;
				}
			}
		} while (permut == true);
	}
}