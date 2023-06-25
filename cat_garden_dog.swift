import UIKit

// MARK: - Networking and Business Conference

class NetworkingBusinessConference {
  
  // MARK: Properties
  
  var name: String // name of event
  var location: String // location of event
  var date: Date // date of event
  var startTime: Date // start time of event
  var endTime: Date // end time of event
  var speakerCount: Int // number of scheduled speakers
  var attendees: [String] // names of registered attendees
  var categories: [String] // categories of topics for event
  var sessionTopics: [String] // specific topics discussed during sessions

  // MARK: Initializer

  init(name: String, location: String, date: Date, startTime: Date, endTime: Date, speakerCount: Int, attendees: [String], categories: [String], sessionTopics: [String]) {
    self.name = name
    self.location = location
    self.date = date
    self.startTime = startTime
    self.endTime = endTime
    self.speakerCount = speakerCount
    self.attendees = attendees
    self.categories = categories
    self.sessionTopics = sessionTopics
  }
  
  // MARK: Methods

  func registerAttendee(name: String) {
    // add attendee to attendees array
    attendees.append(name)
  }
  
  func addSessionTopic(topic: String) {
    // add topic to session topics array
    sessionTopics.append(topic)
  }
  
  func printEventDetails() {
    // print event details
    print("Name: \(name)")
    print("Location: \(location)")
    print("Date: \(date)")
    print("Start Time: \(startTime)")
    print("End Time: \(endTime)")
    print("Speaker Count: \(speakerCount)")
    print("Attendees: \(attendees)")
    print("Categories: \(categories)")
    print("Session Topics: \(sessionTopics)")
  }
}