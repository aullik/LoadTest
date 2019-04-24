# LoadTest

<b>Lecture: Cloud Application Development</b> <br>

Simple LoadTest using [Gatling](https://gatling.io/) <br>
=> Simulate autoscaling of a cloud project

## Git Clone
`git clone https://github.com/aullik/LoadTest.git`

## Sbt
`$ sbt` 

## Run Tests 

### Minimum Test (1 User for 1 Minute) 
`gatling:testOnly de.htwg.loadTest.MinimumLoadTest`

### Maximum Test (48 User for 1 Minute) 
`gatling:testOnly de.htwg.loadTest.MaximumLoadTest`
