import './styles.css';
import {ReactComponent as YoutubeImg} from './youtube.svg';
import {ReactComponent as LinkedinImg} from './linkedin.svg';
import {ReactComponent as InstagramImg} from './instagram.svg';


function Footer(){
        return(

            <footer className="main-footer">
            
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior

            <div className="footer-icons">
            <a href="#" target="_new">
                <YoutubeImg/>
                </a>
            <a href="#" target="_new">
                <LinkedinImg/>
                </a>
            <a href="#" target="_new">
                <InstagramImg/>
                </a>
            </div>

            </footer>
        )

}

export default Footer;