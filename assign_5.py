def chatbot():
    print("Welcome to ShopEase! 🛍 How can I help you today?")
    print("Type 'bye' to end the chat.\n")

    while True:
        user_input = input("You: ").lower()

        if "hello" in user_input or "hi" in user_input:
            print("Bot: Hello! How can I assist you today?")

        elif "order" in user_input and "status" in user_input:
            print("Bot: Please provide your order ID to check the status.")

        elif "return" in user_input or "refund" in user_input:
            print("Bot: To request a return, please visit our returns page or provide your order ID.")

        elif "cancel" in user_input:
            print("Bot: I can help you with that. What is your order ID?")

        elif "contact" in user_input or "email" in user_input:
            print("Bot: You can reach our support team at support@shopease.com or call 123-456-7890.")

        elif "bye" in user_input or "exit" in user_input:
            print("Bot: Thank you for chatting with ShopEase! Have a great day 😊")
            break

        else:
            print("Bot: I'm sorry, I didn't understand that. Can you rephrase your question?")

# Run the chatbot
chatbot()