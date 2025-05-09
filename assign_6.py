# Defineadictionaryofcommonproblemsandtheirsolutions 
problem_dict = {
"Printer not working": "Check that it's turned on and connected to the network", 
"Can't log in": "Make sure you're using the correct username and password", 
"Softwarenotinstalling":"Checkthatyourcomputermeetsthesystemrequirements", 
"Internet connection not working": "Restart your modem or router",
"Emailnotsending": "Checkthatyou'reusingthecorrectemailserver settings"
}
#Defineafunctiontohandleuserrequests
def handle_request(user_input):
  if user_input.lower()=="exit":
      return "Goodbye!"
  elif user_input in problem_dict: 
    return problem_dict[user_input]
  else:
   return"I'msorry,Idon'tknowhowtohelpwiththat problem."
#Mainlooptopromptuserforinput
while True:
   user_input=input("What'stheproblem?Type'exit'toquit.") 
   response = handle_request(user_input)
   print(response)
