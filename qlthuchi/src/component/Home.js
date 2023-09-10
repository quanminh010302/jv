import { useEffect, useState } from "react";
import Apis, { endpoints } from "../config/Apis";
import { Button, Card, Col, Row, } from "react-bootstrap";
import MySpinner from "./MySpinner";


const Home = () => {
    const [type, setType] = useState(null);
    const loadCates = async () => {
        try {
            let res = await Apis.get(endpoints[`type`])
            setType(res.data);
        } catch (ex) {
            console.error(ex);

        }
    }
    useEffect(() => {
        loadCates();
    }, []
    )

    if (type === null) {
        return <MySpinner />;
    }
    return (
        <>
            <Row>


                {type.map(t => {
                    return <Col xs={12} md={2} className="mt-2">
                        <Card style={{
                            width: '15rem',
                            border: '3px solid black'
                        }}>
                            <Card.Img variant="top" src="logo192.png" />
                            <Card.Body>
                                <Card.Title>{t.name}</Card.Title>
                                <Button variant="primary">Thêm phiếu Thu</Button>
                                <Button variant="success">Thêm phiếu Chi</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                })}

            </Row>


        </>
    )
}
export default Home;