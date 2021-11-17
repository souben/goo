package main

import (
	"fmt"
	"io"
	"log"
	"net/url"

	"github.com/gorilla/websocket"
)

func main() {

	addr := "localhost:7000"
	u := url.URL{Scheme: "ws", Host: addr, Path: "/ws"}
	log.Printf("connectingto %s", u.String())

	c, _, err := websocket.DefaultDialer.Dial(u.String(), nil)
	if err != nil {
		log.Fatal("dial:", err)
	}

	defer c.Close()

	done := make(chan struct{})

	go readMessage(c, done)

	<-done
}

func readMessage(conn *websocket.Conn, ch chan struct{}) {
	defer conn.Close()

	for {
		_, message, err := conn.ReadMessage()
		if err != nil || err == io.EOF {
			log.Fatal("Error reading :", err)
			break
		}

		fmt.Printf("recv: %s", message)
	}
}
